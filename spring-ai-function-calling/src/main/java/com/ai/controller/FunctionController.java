package com.ai.controller;

import com.ai.service.FunctionCallingService;
import java.util.Collections;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class FunctionController {

  private final FunctionCallingService service;

  public FunctionController(FunctionCallingService service) {
    this.service = service;
  }

  @PostMapping("/fn/plan")
  public ResponseEntity<Map<String, String>> plan(@RequestBody Map<String, String> body) {
    String prompt = body.get("prompt");
    if (prompt == null || prompt.trim().isEmpty()) {
      return ResponseEntity.badRequest()
          .body(Collections.singletonMap("error", "prompt is required"));
    }
    String assistant = service.planTrip(prompt);
    return ResponseEntity.ok(Collections.singletonMap("assistant", assistant));
  }
}
