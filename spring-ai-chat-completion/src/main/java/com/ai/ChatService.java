package com.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

  private final ChatClient chatClient;

  public ChatService(ChatClient chatClient) {
    this.chatClient = chatClient;
  }

  // Synchronous completion
  public String completion(String message) {
    return this.chatClient.prompt() //
        .user(message) //
        .call() //
        .content();
  }
}
