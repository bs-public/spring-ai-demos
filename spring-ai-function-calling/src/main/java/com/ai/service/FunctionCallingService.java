package com.ai.service;

import com.ai.tools.TravelTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class FunctionCallingService {

  private final ChatClient chatClient;
  private final TravelTools travelTools;

  public FunctionCallingService(ChatClient chatClient, TravelTools travelTools) {
    this.chatClient = chatClient;
    this.travelTools = travelTools;
  }

  public String planTrip(String userPrompt) {
    return chatClient
        .prompt()
        .user(userPrompt)
        .tools(travelTools) // provide tool(s) to model
        .call()
        .content();
  }
}
