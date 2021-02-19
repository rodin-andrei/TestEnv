package com.unifun.spamBeeper.repository;

import com.unifun.spamBeeper.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findAllByOrderByPriorityDesc();
    Optional<Company> findByIsDefault(boolean isDefault);
}
