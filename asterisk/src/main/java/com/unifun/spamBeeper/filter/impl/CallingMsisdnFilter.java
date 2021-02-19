package com.unifun.spamBeeper.filter.impl;

import com.unifun.spamBeeper.common.CallInfo;
import com.unifun.spamBeeper.filter.Filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("CallingMsisdnFilter")
public class CallingMsisdnFilter implements Filter {
    @Override
    public boolean test(CallInfo callInfo, String condition) {
        return callInfo.getCallingMsisdn().equals(condition);
    }
}
