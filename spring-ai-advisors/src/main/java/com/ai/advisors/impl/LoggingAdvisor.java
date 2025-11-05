package com.ai.advisors.impl;

import com.ai.advisors.PromptAdvisor;
import com.ai.advisors.context.PromptContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Logging advisor that masks emails and credit-card-like patterns. */
public class LoggingAdvisor implements PromptAdvisor {
  private static final Logger logger = LoggerFactory.getLogger(LoggingAdvisor.class);

  @Override
  public PromptContext advise(PromptContext ctx) {
    String masked = maskSensitive(ctx.getUser());
    logger.info("[prompt] system={} userPreview={}", ctx.getSystem(), masked);
    return ctx;
  }

  private String maskSensitive(String s) {
    if (s == null) {
      return null;
    }
    // mask: emails -> <email>, digits -> X
    String step = s.replaceAll("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}", "<email>");
    return step.replaceAll("\\d", "X");
  }
}
