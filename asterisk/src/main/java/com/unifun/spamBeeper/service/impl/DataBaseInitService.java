package com.unifun.spamBeeper.service.impl;

import com.unifun.spamBeeper.model.Company;
import com.unifun.spamBeeper.model.CompanyFilter;
import com.unifun.spamBeeper.model.Prompt;
import com.unifun.spamBeeper.repository.CompanyFilterRepository;
import com.unifun.spamBeeper.repository.CompanyRepository;
import com.unifun.spamBeeper.repository.PromptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class DataBaseInitService {
    private final CompanyRepository companyRepository;
    private final CompanyFilterRepository companyFilterRepository;
    private final PromptRepository promptRepository;


    @PostConstruct
    private void init() {
        Prompt prompt1 = Prompt.builder()
                .path("yes-dear")
                .name("Звук1")
                .build();
        Prompt prompt2 = Prompt.builder()
                .path("you-can-press")
                .name("Звук 2")
                .build();
        promptRepository.save(prompt1);
        promptRepository.save(prompt2);

        Company company = new Company();
        company.setName("Складовка");
        company.setPriority(1);
        company.setActive(true);
        company.setPrompt(prompt1);
        company.setEarlyMedia(true);


        companyRepository.save(company);

        CompanyFilter companyFilter = new CompanyFilter();
        companyFilter.setName("CallingMsisdnFilter");
        companyFilter.setCondition("unifun");
        companyFilter.setCompany(company);
        companyFilterRepository.save(companyFilter);

        CompanyFilter companyFilter3 = new CompanyFilter();
        companyFilter3.setName("CalledMsisdnFilter");
        companyFilter3.setCondition("888");
        companyFilter3.setCompany(company);
        companyFilterRepository.save(companyFilter3);

        Company company2 = new Company();
        company2.setName("Новая рекламная компания");
        company2.setPriority(2);
        company2.setActive(true);
        company2.setPrompt(prompt2);
        companyRepository.save(company2);
        company2.setEarlyMedia(false);


        CompanyFilter companyFilter2 = new CompanyFilter();
        companyFilter2.setName("CalledMsisdnFilter");
        companyFilter2.setCondition("69744353");
        companyFilter2.setCompany(company2);
        companyFilterRepository.save(companyFilter2);


        Company defaultCompany = new Company();
        defaultCompany.setName("Default");
        defaultCompany.setPriority(-1);
        defaultCompany.setActive(true);
        defaultCompany.setDefault(true);
        defaultCompany.setPrompt(prompt1);
        defaultCompany.setEarlyMedia(true);
        companyRepository.save(defaultCompany);
    }
}
