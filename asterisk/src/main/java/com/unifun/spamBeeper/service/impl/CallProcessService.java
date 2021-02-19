package com.unifun.spamBeeper.service.impl;

import ch.loway.oss.ari4java.generated.models.Playback;
import com.unifun.spamBeeper.action.callback.CallBack;
import com.unifun.spamBeeper.action.impl.AnswerAction;
import com.unifun.spamBeeper.action.impl.HangupAction;
import com.unifun.spamBeeper.action.impl.PlaybackAction;
import com.unifun.spamBeeper.common.CallInfo;
import com.unifun.spamBeeper.model.Company;
import com.unifun.spamBeeper.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CallProcessService {
    private final CompanyService companyService;
    private final PlaybackAction playbackAction;
    private final HangupAction hangupAction;
    private final AnswerAction answerAction;

    public void startCallProcess(CallInfo callInfo) {
        selectCompany(callInfo);
        playCompany(callInfo);
    }

    private void selectCompany(CallInfo callInfo) {
        Company availableCompany = companyService.findAvailableCompany(callInfo);
        callInfo.setCompany(availableCompany);
        log.info("Selected company {}", availableCompany.getName());
    }

    private void playCompany(CallInfo callInfo) {
        if (callInfo.getCompany().isEarlyMedia()) {
            answerAction.doAction(callInfo, null, new CallBack<Void>() {
                @Override
                public void onSuccess(Void param) {
                    log.info("OOOOOK");
                    playPrompt(callInfo);
                }

                @Override
                public void ofFailure(Exception e) {
                    log.error("UUUPS");
                }
            });
        } else {
            playPrompt(callInfo);
        }


    }

    private void playPrompt(CallInfo callInfo) {
        playbackAction.doAction(callInfo, callInfo.getCompany().getPrompt().getPath(), new CallBack<Playback>() {
            @Override
            public void onSuccess(Playback param) {
                log.info("End playing prompt, channel {}", callInfo.getChannelId());
                hangupAction.doAction(callInfo);
            }

            @Override
            public void ofFailure(Exception e) {
                log.warn("Failure playing prompt");
            }
        });
    }
}
