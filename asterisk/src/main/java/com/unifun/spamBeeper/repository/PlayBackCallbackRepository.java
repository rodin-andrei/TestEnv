package com.unifun.spamBeeper.repository;

import ch.loway.oss.ari4java.generated.models.Playback;
import com.unifun.spamBeeper.action.callback.CallBack;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class PlayBackCallbackRepository {
    private Map<String, CallBack<Playback>> callbackMap = new HashMap<>();

    public Optional<CallBack<Playback>> findByPlayBackId(String playBackId) {
        return Optional.ofNullable(callbackMap.get(playBackId));
    }

    public void save(String playBackId, CallBack<Playback> ariCallback) {
        callbackMap.put(playBackId, ariCallback);
    }
}
