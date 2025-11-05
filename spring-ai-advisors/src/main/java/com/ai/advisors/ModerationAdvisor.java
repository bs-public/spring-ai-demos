package com.ai.advisors;

import com.ai.advisors.context.PromptContext;
import com.ai.advisors.exception.ModerationException;

/**
 * ModerationAdvisor may throw ModerationException to block the call, or return a sanitized
 * PromptContext.
 */
public interface ModerationAdvisor {

  PromptContext moderate(PromptContext ctx) throws ModerationException;
}
