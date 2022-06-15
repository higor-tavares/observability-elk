package com.higortavares.observabilityelk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
@Slf4j
public class HelloWorldController {
  @GetMapping
  public ResponseEntity<?> sayHello() {
    log.info("say hello...");
    return ResponseEntity.ok("Hello World!");
  }
}
