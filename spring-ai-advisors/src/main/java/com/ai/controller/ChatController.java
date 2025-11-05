package com.ai.controller;

import com.ai.advisors.exception.ModerationException;
import com.ai.dto.ChatRequest;
import com.ai.dto.ChatResponse;
import com.ai.service.AdvisingChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

  private final AdvisingChatService advisingChatService;

  public ChatController(AdvisingChatService advisingChatService) {
    this.advisingChatService = advisingChatService;
  }

  @PostMapping("/v1/chat/completions")
  public ResponseEntity<ChatResponse> completion(@RequestBody ChatRequest request) {
    try {
      String system = request.getSystemPrompt();
      String message = request.getMessage();
      String result = advisingChatService.complete(system, message);
      return ResponseEntity.ok(new ChatResponse(result));
    } catch (ModerationException me) {
      return ResponseEntity.status(400)
              .body(new ChatResponse("Moderation blocked: " + me.getMessage()));
    } catch (Exception ex) {
      return ResponseEntity.status(500).body(new ChatResponse("Model error: " + ex.getMessage()));
    }
  }
}
