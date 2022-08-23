package com.higortavares.userapi.controller;

import com.higortavares.userapi.annotations.LoggableHttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
@Slf4j
public class SayHello {

  @GetMapping("/")
  @LoggableHttpRequest
  public ResponseEntity<?> sayHello(){
    log.info("Say hello to user...");
    return ResponseEntity.ok("Hello!");
  }
}
