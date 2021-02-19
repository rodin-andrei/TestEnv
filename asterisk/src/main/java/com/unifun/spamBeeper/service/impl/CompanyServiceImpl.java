package com.unifun.spamBeeper.service.impl;

import com.unifun.spamBeeper.common.CallInfo;
import com.unifun.spamBeeper.filter.Filter;
import com.unifun.spamBeeper.model.Company;
import com.unifun.spamBeeper.repository.CompanyRepository;
import com.unifun.spamBeeper.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final Map<String, Filter> filters;

    @Override
    public Company findAvailableCompany(CallInfo callInfo) {
        Optional<Company> selectedCompany = companyRepository.findAllByOrderByPriorityDesc().stream()
                .filter(Company::isActive)
                .filter(company -> {
                            log.info("Start filters compliance checking of company:{}", company.getName());
                            return company.getFilters().stream()
                                    .allMatch(companyFilter -> {
                                        boolean result = filters.get(companyFilter.getName())
                                                .test(callInfo, companyFilter.getCondition());
                                        log.info("Filter:{}, condition: {}, result: {} ", companyFilter.getName(), companyFilter.getCondition(), result);
                                        return result;
                                    });
                        }
                ).findFirst();
        return selectedCompany.orElseGet(() -> companyRepository.findByIsDefault(true).get());

    }
}

