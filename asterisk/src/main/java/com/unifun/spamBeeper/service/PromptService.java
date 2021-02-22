package com.unifun.spamBeeper.service;

import com.unifun.spamBeeper.model.Prompt;

import java.util.List;

public interface PromptService {
    Prompt getPromptById(Long id);
    List<Prompt> getAllPrompts();
    Prompt registerPrompt(Prompt prompt);
    void deletePrompt(Prompt prompt);
}
