package com.ai.advisors;

import com.ai.advisors.context.PromptContext;

public interface PromptAdvisor {

  /** Mutate or annotate the provided prompt context before the model call. */
  PromptContext advise(PromptContext ctx);
}
