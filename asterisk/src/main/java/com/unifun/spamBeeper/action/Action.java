package com.unifun.spamBeeper.action;

import com.unifun.spamBeeper.action.callback.CallBack;
import com.unifun.spamBeeper.common.CallInfo;

public interface Action<T> {
    void doAction(CallInfo callInfo);

    void doAction(CallInfo callInfo, String param) throws InterruptedException;

    void doAction(CallInfo callInfo, String param, CallBack<T> callBack);
}
