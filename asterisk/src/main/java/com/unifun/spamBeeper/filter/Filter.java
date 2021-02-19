package com.unifun.spamBeeper.filter;

import com.unifun.spamBeeper.common.CallInfo;

import java.util.function.BiPredicate;

public interface Filter extends BiPredicate<CallInfo, String> {
}
