package com.salim.notemap.controller;

import com.salim.notemap.services.PdfAnalyzer;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AiController {

    private final ChatClient chatClient;
    private final PdfAnalyzer pdfAnalyzer;

    @GetMapping("/ai")
    public String getAiResponse(@RequestParam(required = false) String query){

//        String userMsg = "Spring Boot is a popular Java-based framework used to build web applications, REST APIs, and microservices quickly and efficiently. It is built on top of the Spring Framework and simplifies application development by providing features such as auto-configuration, embedded servers, dependency management, and production-ready tools. With Spring Boot, developers can create applications with minimal configuration and easily integrate databases, security, messaging systems, and other services. Its simplicity, scalability, and strong ecosystem make Spring Boot a widely used technology for developing modern enterprise applications.";
//        String systemMsg = "Summarize this data and turned it into important points to create an flowchart from the data.";

//        Prompt prompt = Prompt.builder()
//                .content(query)
//                .chatOptions(ChatOptions
//                        .builder()
//                        .model("poolside/laguna-s-2.1:free")
//                        .build())
//                .build();

        Prompt prompt = Prompt.builder()
                .content(query)
                .chatOptions(ChatOptions
                        .builder()
                        .model("nvidia/nemotron-3.5-lightning:free")
                        .build())
                .build();

        return chatClient.prompt(prompt).call().content();
    }

    @PostMapping("/upload/pdf")
    public ResponseEntity<?> uploadPdf(@RequestParam("file") MultipartFile file){

        List<String> response = pdfAnalyzer.pdfToDocumentReader(file);

        return ResponseEntity.ok(response);
    }
}
