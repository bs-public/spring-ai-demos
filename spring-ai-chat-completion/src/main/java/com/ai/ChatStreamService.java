package com.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatStreamService {

  private final ChatClient chatClient;

  public ChatStreamService(ChatClient chatClient) {
    this.chatClient = chatClient;
  }

  // Streaming completion
  public Flux<String> streamCompletion(String message) {
    return this.chatClient.prompt() //
        .user(message) //
        .stream() //
        .content();
  }
}
