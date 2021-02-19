package com.unifun.spamBeeper.repository;

import com.unifun.spamBeeper.model.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromptRepository extends JpaRepository<Prompt, Long> {
}
