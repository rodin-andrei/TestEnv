package com.unifun.spamBeeper.controller;

import com.unifun.spamBeeper.model.CompanyFilter;
import com.unifun.spamBeeper.service.CompanyFilterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/companyFilter")
@RequiredArgsConstructor
public class CompanyFilterController {

    private final CompanyFilterService companyFilterService;

    @GetMapping("/all")
    private List<CompanyFilter> getAll() {
        return companyFilterService.getAll();
    }

    @GetMapping("/{id}")
    private CompanyFilter getById(@PathVariable("id") Long id) {
        return companyFilterService.getById(id);
    }

    @PostMapping("/create")
    private CompanyFilter create(@RequestBody CompanyFilter company) {
        return companyFilterService.register(company);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable Long id) {
        CompanyFilter companyFilter = new CompanyFilter();
        companyFilter.setId(id);
        companyFilterService.delete(companyFilter);
    }

}
