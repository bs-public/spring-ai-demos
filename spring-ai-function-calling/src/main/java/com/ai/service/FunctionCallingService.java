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

  public String planTrip(String userPrompt, String systemPrompt) {

    ChatClient.ChatClientRequestSpec spec = chatClient.prompt();

    if (systemPrompt != null && !systemPrompt.trim().isEmpty()) {
      spec = spec.system(systemPrompt);
    }

    return spec //
        .user(userPrompt) //
        .tools(travelTools) //
        .call() //
        .content();
  }
}
