package com.ai.controller;

import com.ai.dto.ChatRequest;
import com.ai.dto.ChatResponse;
import com.ai.service.FunctionCallingService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
@Validated
public class FunctionController {

  private final FunctionCallingService service;

  public FunctionController(FunctionCallingService service) {
    this.service = service;
  }

  @PostMapping("/chat/completions")
  public ResponseEntity<ChatResponse> chat(@Valid @RequestBody ChatRequest request) {
    String assistant = service.planTrip(request.getMessage(), request.getSystemPrompt());
    ChatResponse resp = new ChatResponse(assistant);
    return ResponseEntity.ok(resp);
  }
}
