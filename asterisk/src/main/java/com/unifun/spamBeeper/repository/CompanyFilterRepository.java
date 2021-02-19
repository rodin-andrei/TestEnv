package com.unifun.spamBeeper.repository;

import com.unifun.spamBeeper.model.CompanyFilter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyFilterRepository extends JpaRepository<CompanyFilter, Long> {
}
