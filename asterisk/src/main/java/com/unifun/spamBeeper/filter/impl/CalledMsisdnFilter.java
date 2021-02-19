package com.unifun.spamBeeper.filter.impl;

import com.unifun.spamBeeper.common.CallInfo;
import com.unifun.spamBeeper.filter.Filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("CalledMsisdnFilter")
public class CalledMsisdnFilter implements Filter {
    @Override
    public boolean test(CallInfo callInfo, String condition) {
        return callInfo.getCalledMsisdn().equals(condition);
    }
}
