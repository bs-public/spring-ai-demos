package com.ai;

import java.util.Collections;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {

  private final ChatService chatService;
  private final ChatStreamService chatStreamService;

  public ChatController(ChatService chatService, ChatStreamService chatStreamService) {
    this.chatService = chatService;
    this.chatStreamService = chatStreamService;
  }

  @GetMapping("/v1/chat/completions")
  public ResponseEntity<Map<String, String>> completion(
      @RequestParam(value = "message") String message) {
    String response = chatService.completion(message);
    return ResponseEntity.ok(Collections.singletonMap("completion", response));
  }

  @GetMapping(value = "/v1/chat/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<String> streamCompletion(@RequestParam("message") String message) {
    return chatStreamService.streamCompletion(message);
  }
}
