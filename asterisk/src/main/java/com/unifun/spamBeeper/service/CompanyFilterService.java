package com.unifun.spamBeeper.service;

import com.unifun.spamBeeper.model.CompanyFilter;

import java.util.List;

public interface CompanyFilterService {
    CompanyFilter getCompanyFilterById(Long id);

    List<CompanyFilter> getAllCompanyFilters();

    CompanyFilter registerCompanyFilter(CompanyFilter filter);

    void deleteCompanyFilter(CompanyFilter filter);
}
