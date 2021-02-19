package com.unifun.spamBeeper.action.impl;

import ch.loway.oss.ari4java.ARI;
import ch.loway.oss.ari4java.tools.RestException;
import com.unifun.spamBeeper.action.Action;
import com.unifun.spamBeeper.action.callback.CallBack;
import com.unifun.spamBeeper.common.CallInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("HangupAction")
@RequiredArgsConstructor
public class HangupAction implements Action<Void> {

    private final ARI ari;

    @Override
    public void doAction(CallInfo callInfo) {
        log.info("Do HangupAction for channel {}", callInfo.getChannelId());
        try {
            ari.channels().hangup(callInfo.getChannelId()).execute();
        } catch (RestException e) {
            log.error("Error execute HangupAction, {}", e.getMessage(), e);
        }
    }

    @Override
    public void doAction(CallInfo callInfo, String param) {
        this.doAction(callInfo);
    }

    @Override
    public void doAction(CallInfo callInfo, String param, CallBack<Void> callBack) {
        log.info("Do HangupAction for channel {}", callInfo.getChannelId());
        try {
            ari.channels().hangup(callInfo.getChannelId()).execute();
            callBack.onSuccess(null);
        } catch (RestException e) {
            log.error("Error execute HangupAction, {}", e.getMessage(), e);
            callBack.ofFailure(null);
        }
    }
}
