package com.unifun.spamBeeper.service;

import com.unifun.spamBeeper.model.CompanyFilter;

import java.util.List;

public interface CompanyFilterService {
    CompanyFilter getById(Long id);

    List<CompanyFilter> getAll();

    CompanyFilter register(CompanyFilter filter);

    void delete(CompanyFilter filter);
}
