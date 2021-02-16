package com.unifun.spamBeeper.controller;

import com.unifun.spamBeeper.service.AriWsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "sounds")
@RequiredArgsConstructor
public class SoundController {
    private final AriWsListener ariWsListener;

    @GetMapping(path = "set")
    public void setSound(@RequestParam String sound){
                    ariWsListener.setSoundName(sound);
    }
}
