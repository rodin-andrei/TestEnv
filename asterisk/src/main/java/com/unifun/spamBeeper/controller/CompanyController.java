package com.unifun.spamBeeper.controller;

import com.unifun.spamBeeper.model.Company;
import com.unifun.spamBeeper.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/all")
    private List<Company> getAll() {
        return companyService.getAll();
    }

    @GetMapping("/{id}")
    private Company getById(@PathVariable("id") Long id) {
        return companyService.getById(id);
    }

    @PostMapping("/create")
    private Company create(@RequestBody Company company) {
        return companyService.register(company);
    }
}
