package com.unifun.spamBeeper.controller;

import com.unifun.spamBeeper.model.Prompt;
import com.unifun.spamBeeper.service.PromptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("prompt")
@RequiredArgsConstructor
public class PromptController {

    private final PromptService promptService;

    @GetMapping("/all")
    private List<Prompt> getAll() {
        return promptService.getAll();
    }

    @GetMapping("/{id}")
    private Prompt getById(@PathVariable("id") Long id) {
        return promptService.getById(id);
    }

    @PostMapping("/create")
    private Prompt create(@RequestBody  Prompt prompt) {
        return promptService.register(prompt);
    }
}
