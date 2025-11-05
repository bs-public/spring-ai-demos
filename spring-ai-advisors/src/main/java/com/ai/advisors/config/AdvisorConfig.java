package com.ai.advisors.config;

import com.ai.advisors.ModerationAdvisor;
import com.ai.advisors.PromptAdvisor;
import com.ai.advisors.ResponseAdvisor;
import com.ai.advisors.impl.BasicContentModerationAdvisor;
import com.ai.advisors.impl.LoggingAdvisor;
import com.ai.advisors.impl.LowercaseResponseAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AdvisorConfig {

  @Bean
  public PromptAdvisor loggingAdvisor() {
    return new LoggingAdvisor();
  }

  @Bean
  public ModerationAdvisor moderationAdvisor() {
    return new BasicContentModerationAdvisor();
  }

  @Bean
  public ResponseAdvisor lowercaseResponseAdvisor() {
    return new LowercaseResponseAdvisor();
  }

  @Bean
  public List<PromptAdvisor> promptAdvisors(PromptAdvisor loggingAdvisor) {
    List<PromptAdvisor> l = new ArrayList<PromptAdvisor>();
    l.add(loggingAdvisor);
    return l;
  }

  @Bean
  public List<ResponseAdvisor> responseAdvisors(ResponseAdvisor lowercaseResponseAdvisor) {
    List<ResponseAdvisor> l = new ArrayList<ResponseAdvisor>();
    l.add(lowercaseResponseAdvisor);
    return l;
  }
}
