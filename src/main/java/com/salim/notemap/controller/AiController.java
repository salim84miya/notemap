package com.salim.notemap.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AiController {

    private final ChatClient chatClient;

    @GetMapping("/ai")
    public String getAiResponse(@RequestParam String query){

        return chatClient.prompt(query)
                .call()
                .content();
    }
}
