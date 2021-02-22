package com.unifun.spamBeeper.service.impl;

import com.unifun.spamBeeper.model.Prompt;
import com.unifun.spamBeeper.repository.PromptRepository;
import com.unifun.spamBeeper.service.PromptService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PromptServiceImpl implements PromptService {

    private final PromptRepository promptRepository;

    @Value("${asterisk.prompt-path}")
    private String soundPath;


    @Override
    public Prompt getById(Long id) {
        return promptRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT));
    }

    @Override
    public List<Prompt> getAll() {
        return promptRepository.findAll();
    }

    @SneakyThrows
    @Override
    public Prompt register(Prompt prompt, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        // Copy file to the target location (Replacing existing file with the same name)
        Path targetLocation = new File(soundPath + fileName).toPath();
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return promptRepository.save(prompt);
    }

    @Override
    public void delete(Prompt prompt) {
        promptRepository.delete(prompt);
    }
}
