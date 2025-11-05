package com.ai.advisors.impl;

import com.ai.advisors.ResponseAdvisor;

/** ResponseAdvisor that post-processes model responses. */
public class LowercaseResponseAdvisor implements ResponseAdvisor {

  @Override
  public String advise(String response) {
    if (response == null) {
      return null;
    }
    // trim whitespace, normalize spacing, and convert to lowercase
    return response.trim().replaceAll("\\s+", " ").toLowerCase();
  }
}
