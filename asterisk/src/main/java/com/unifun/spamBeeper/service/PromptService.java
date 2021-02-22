package com.unifun.spamBeeper.service;

import com.unifun.spamBeeper.model.Prompt;

import java.util.List;

public interface PromptService {
    Prompt getById(Long id);
    List<Prompt> getAll();
    Prompt register(Prompt prompt);
    void delete(Prompt prompt);
}
