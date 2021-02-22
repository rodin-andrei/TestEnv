package com.unifun.spamBeeper.service;

import com.unifun.spamBeeper.model.Prompt;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PromptService {
    Prompt getById(Long id);
    List<Prompt> getAll();
    Prompt register(Prompt prompt, MultipartFile file);
    void delete(Prompt prompt);
}
