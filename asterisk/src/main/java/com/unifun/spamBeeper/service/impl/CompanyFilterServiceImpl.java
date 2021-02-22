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

    private final CompanyFilterRepository companyFilterRepository;

    @Override
    public CompanyFilter getById(Long id) {
        return companyFilterRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT));
    }

    @Override
    public List<CompanyFilter> getAll() {
        return companyFilterRepository.findAll();
    }

    @Override
    public CompanyFilter register(CompanyFilter filter) {
        return companyFilterRepository.save(filter);
    }

    @Override
    public void delete(CompanyFilter filter) {
        companyFilterRepository.delete(filter);
    }
}
