package com.unifun.spamBeeper.service.impl;

import com.unifun.spamBeeper.model.CompanyFilter;
import com.unifun.spamBeeper.repository.CompanyFilterRepository;
import com.unifun.spamBeeper.service.CompanyFilterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyFilterServiceImpl implements CompanyFilterService {

    private CompanyFilterRepository companyFilterRepository;

    @Override
    public CompanyFilter getCompanyFilterById(Long id) {
        return companyFilterRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT));
    }

    @Override
    public List<CompanyFilter> getAllCompanyFilters() {
        return companyFilterRepository.findAll();
    }

    @Override
    public CompanyFilter registerCompanyFilter(CompanyFilter filter) {
        return companyFilterRepository.save(filter);
    }

    @Override
    public void deleteCompanyFilter(CompanyFilter filter) {
        companyFilterRepository.delete(filter);
    }
}
