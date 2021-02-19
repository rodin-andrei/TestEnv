package com.unifun.spamBeeper.action.impl;

import ch.loway.oss.ari4java.ARI;
import com.unifun.spamBeeper.action.Action;
import com.unifun.spamBeeper.action.callback.CallBack;
import com.unifun.spamBeeper.common.CallInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service("RedirectAction")
public class RedirectAction implements Action<Void> {
    private final ARI ari;

    @Override
    public void doAction(CallInfo callInfo) {

    }

    @Override
    public void doAction(CallInfo callInfo, String param) {

    }

    @Override
    public void doAction(CallInfo callInfo, String param, CallBack callBack) {

    }
}
