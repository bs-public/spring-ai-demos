package com.ai.service;

import com.ai.advisors.ModerationAdvisor;
import com.ai.advisors.exception.ModerationException;
import com.ai.advisors.PromptAdvisor;
import com.ai.advisors.context.PromptContext;
import com.ai.advisors.ResponseAdvisor;
import java.util.List;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

/** Service that runs the advisor pipeline and delegates to ChatClient. */
@Service
public class AdvisingChatService {

  private final List<PromptAdvisor> promptAdvisors;
  private final ModerationAdvisor moderationAdvisor;
  private final List<ResponseAdvisor> responseAdvisors;
  private final ChatClient chatClient;

  public AdvisingChatService(
      List<PromptAdvisor> promptAdvisors,
      ModerationAdvisor moderationAdvisor,
      List<ResponseAdvisor> responseAdvisors,
      ChatClient chatClient) {
    this.promptAdvisors = promptAdvisors;
    this.moderationAdvisor = moderationAdvisor;
    this.responseAdvisors = responseAdvisors;
    this.chatClient = chatClient;
  }

  /** Advisor pipeline. */
  public String complete(String systemPrompt, String userMessage) throws ModerationException {
    PromptContext ctx = new PromptContext(systemPrompt, userMessage);

    // run prompt advisors (in injected order)
    for (PromptAdvisor promptAdvisor : promptAdvisors) {
      ctx = promptAdvisor.advise(ctx);
    }

    // moderation (may throw ModerationException)
    ctx = moderationAdvisor.moderate(ctx);

    String raw =
        chatClient
            .prompt() //
            .system(ctx.getSystem()) //
            .user(ctx.getUser()) //
            .call() //
            .content();

    // response post-processing
    String advised = raw;
    for (ResponseAdvisor ra : responseAdvisors) {
      advised = ra.advise(advised);
    }
    return advised;
  }
}
