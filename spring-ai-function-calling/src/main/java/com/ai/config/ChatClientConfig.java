package com.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

  @Bean
  ChatClient chatClient(ChatClient.Builder builder) {
    return builder
        .defaultSystem(
            "You are a helpful and professional assistant that provides clear and accurate answers.")
        .build();
  }
}
