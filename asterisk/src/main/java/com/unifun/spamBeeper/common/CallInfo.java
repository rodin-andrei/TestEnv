package com.unifun.spamBeeper.common;

import com.unifun.spamBeeper.filter.Filter;
import com.unifun.spamBeeper.filter.FilterResult;
import com.unifun.spamBeeper.model.Company;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class CallInfo {
    private final String channelId;
    private final String callingMsisdn;
    private final String calledMsisdn;

    private Map<? extends Filter, ? extends FilterResult> filterResultMap;

    private Company company;
}
