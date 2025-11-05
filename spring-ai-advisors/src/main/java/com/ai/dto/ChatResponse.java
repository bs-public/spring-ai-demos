package com.ai.dto;

public class ChatResponse {
  private String completion;

  public ChatResponse() {}

  public ChatResponse(String completion) {
    this.completion = completion;
  }

  public String getCompletion() {
    return completion;
  }

  public void setCompletion(String completion) {
    this.completion = completion;
  }
}
