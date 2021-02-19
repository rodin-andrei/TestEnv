package com.unifun.spamBeeper.action.impl;

import ch.loway.oss.ari4java.ARI;
import ch.loway.oss.ari4java.generated.models.Playback;
import ch.loway.oss.ari4java.tools.AriCallback;
import ch.loway.oss.ari4java.tools.RestException;
import com.unifun.spamBeeper.action.Action;
import com.unifun.spamBeeper.action.callback.CallBack;
import com.unifun.spamBeeper.common.CallInfo;
import com.unifun.spamBeeper.repository.PlayBackCallbackRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service("PlaybackAction")
public class PlaybackAction implements Action<Playback> {

    private final ARI ari;

    private final PlayBackCallbackRepository playBackCallbackRepository;

    @Value("${asterisk.prompt-path}")
    private String soundPath;

    @Override
    public void doAction(CallInfo callInfo) {
        throw new IllegalArgumentException();
    }

    @Override
    public void doAction(CallInfo callInfo, String param) throws InterruptedException {
        log.info("Do PlaybackAction for channel {}, sound {}", callInfo.getChannelId(), param);
        CompletableFuture<Playback> playbackCompletableFuture = new CompletableFuture<>();
        try {
            ari.channels().play(callInfo.getChannelId(), "sound:" + soundPath + param)
                    .execute(new AriCallback<Playback>() {
                        @Override
                        public void onSuccess(Playback playback) {
                            playbackCompletableFuture.complete(playback);
                        }

                        @Override
                        public void onFailure(RestException e) {
                            playbackCompletableFuture.completeExceptionally(e);
                        }
                    });
        } catch (RestException e) {
            //never executable  block
            log.error("Error execute PlaybackAction: {}", e.getMessage(), e);
            playbackCompletableFuture.completeExceptionally(e);
        }
        playbackCompletableFuture.wait();
    }

    @Override
    public void doAction(CallInfo callInfo, String param, CallBack<Playback> ariCallback) {
        log.info("Do PlaybackAction for channel {}, sound {}", callInfo.getChannelId(), param);

        try {
            Playback playback = ari.channels().play(callInfo.getChannelId(), "sound:" + soundPath + param).execute();
            playBackCallbackRepository.save(playback.getId(), ariCallback);
        } catch (RestException e) {
            log.error("Error execute PlaybackAction: {}", e.getMessage(), e);
            ariCallback.ofFailure(e);
        }
    }
}
