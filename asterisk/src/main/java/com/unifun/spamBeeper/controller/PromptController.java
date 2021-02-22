package com.unifun.spamBeeper.controller;

import com.unifun.spamBeeper.model.Prompt;
import com.unifun.spamBeeper.service.PromptService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/prompt")
@RequiredArgsConstructor
public class PromptController {

    private final PromptService promptService;

//    @ExceptionHandler(StorageFileNotFoundException.class)
//    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
//        return ResponseEntity.notFound().build();
//    }


    @GetMapping("/all")
    private List<Prompt> getAll() {
        return promptService.getAll();
    }

    @GetMapping("/{id}")
    private Prompt getById(@PathVariable("id") Long id) {
        return promptService.getById(id);
    }

    @PostMapping(value = "/create",consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    private Prompt create(@RequestBody Prompt prompt, @RequestPart("file") MultipartFile file) {
        return promptService.register(prompt, file);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable Long id) {
        Prompt prompt = new Prompt();
        prompt.setId(id);
        promptService.delete(prompt);
    }
}
