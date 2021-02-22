package com.unifun.spamBeeper.service.impl;

import com.unifun.spamBeeper.model.Prompt;
import com.unifun.spamBeeper.repository.PromptRepository;
import com.unifun.spamBeeper.service.PromptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PromptServiceImpl implements PromptService {

    private final PromptRepository promptRepository;

    @Override
    public Prompt getPromptById(Long id) {
        return promptRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT));
    }

    @Override
    public List<Prompt> getAllPrompts() {
        return promptRepository.findAll();
    }

    @Override
    public Prompt registerPrompt(Prompt prompt) {
        return promptRepository.save(prompt);
    }

    @Override
    public void deletePrompt(Prompt prompt) {
        promptRepository.delete(prompt);
    }
}
