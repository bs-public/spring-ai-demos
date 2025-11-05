package com.ai.advisors.impl;

import com.ai.advisors.ModerationAdvisor;
import com.ai.advisors.exception.ModerationException;
import com.ai.advisors.context.PromptContext;

import java.util.Arrays;
import java.util.List;

public class BasicContentModerationAdvisor implements ModerationAdvisor {

  private final List<String> blacklist = Arrays.asList("badword1", "badword2");

  @Override
  public PromptContext moderate(PromptContext ctx) throws ModerationException {
    String user = ctx.getUser();
    if (user == null) {
      return ctx;
    }
    String lower = user.toLowerCase();
    for (String b : blacklist) {
      if (lower.contains(b)) {
        throw new ModerationException("User input violates policy: contains blocked term");
      }
    }
    // optionally sanitize - example removes blocked words instead of failing
    String sanitized = user;
    for (String b : blacklist) {
      sanitized = sanitized.replaceAll("(?i)" + b, "[redacted]");
    }
    ctx.setUser(sanitized);
    return ctx;
  }
}
