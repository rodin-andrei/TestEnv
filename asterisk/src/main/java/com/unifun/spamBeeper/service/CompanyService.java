package com.unifun.spamBeeper.service;

import com.unifun.spamBeeper.common.CallInfo;
import com.unifun.spamBeeper.model.Company;

import java.util.List;

public interface CompanyService {
    Company findAvailableCompany(CallInfo callInfo);

    Company getById(Long id);

    List<Company> getAll();

    Company register(Company company);

    void delete(Company company);
}
