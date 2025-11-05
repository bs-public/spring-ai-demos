package com.ai.advisors.context;

import java.util.HashMap;
import java.util.Map;

public class PromptContext {
  private String system;
  private String user;
  private final Map<String, Object> metadata = new HashMap<String, Object>();

  public PromptContext() {}

  public PromptContext(String system, String user) {
    this.system = system;
    this.user = user;
  }

  public String getSystem() {
    return system;
  }

  public void setSystem(String system) {
    this.system = system;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public Map<String, Object> getMetadata() {
    return metadata;
  }
}
