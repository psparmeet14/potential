package com.psb.potential;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test controller for demonstration purposes.
 * This controller will be removed later.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final ChatClient chatClient;

    public TestController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @RequestMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam String query) {
        String response = chatClient.prompt(query).call().content();
        return ResponseEntity.ok(response);
    }

}
