package com.unifun.spamBeeper.service;

import com.unifun.spamBeeper.common.CallInfo;
import com.unifun.spamBeeper.model.Company;

public interface CompanyService {
    Company findAvailableCompany(CallInfo callInfo);
}
