package com.ai.advisors;

/**
 * Post-process model responses. Implementations can add annotations, redact, or perform light
 * rewriting.
 */
public interface ResponseAdvisor {

  String advise(String response);
}
