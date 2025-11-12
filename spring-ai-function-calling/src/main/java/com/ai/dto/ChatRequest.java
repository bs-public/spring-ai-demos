package com.ai.dto;

import jakarta.validation.constraints.NotBlank;

public class ChatRequest {

  @NotBlank(message = "message is required")
  private String message;

  private String systemPrompt;

  public ChatRequest() {}

  public ChatRequest(String message, String systemPrompt) {
    this.message = message;
    this.systemPrompt = systemPrompt;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getSystemPrompt() {
    return systemPrompt;
  }

  public void setSystemPrompt(String systemPrompt) {
    this.systemPrompt = systemPrompt;
  }
}
