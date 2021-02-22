package com.unifun.spamBeeper.service;

import com.unifun.spamBeeper.common.CallInfo;
import com.unifun.spamBeeper.model.Company;

import java.util.List;

public interface CompanyService {
    Company findAvailableCompany(CallInfo callInfo);

    Company getCompanyById(Long id);

    List<Company> getAllCompanies();

    Company registerCompany(Company company);

    void deleteCompany(Company company);
}
