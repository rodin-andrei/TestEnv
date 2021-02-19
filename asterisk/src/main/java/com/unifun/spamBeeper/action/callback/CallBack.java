package com.unifun.spamBeeper.action.callback;

public interface CallBack<T> {
    void onSuccess(T param);

    void ofFailure(Exception e);
}
