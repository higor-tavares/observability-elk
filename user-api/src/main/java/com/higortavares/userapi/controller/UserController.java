package com.higortavares.userapi.controller;

import com.higortavares.userapi.annotations.LoggableHttpRequest;
import com.higortavares.userapi.model.UserRequest;
import com.higortavares.userapi.service.UserService;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("user")
@Slf4j
public class UserController {
  @Autowired
  private UserService userService;
  @Autowired
  private RestTemplate restTemplate;

  @LoggableHttpRequest
  @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> save(@RequestBody UserRequest user) {
    try {
      userService.save(user.userEntity());
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (Exception e) {
      log.error("Não foi possivel salvar o usuario {} - ERRO: {}", user, e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @LoggableHttpRequest
  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> findAll() {
    restTemplate.getForObject(String.format("http://localhost:8083/products/cart/%s", UUID.randomUUID()), String.class);
    return ResponseEntity.ok(userService.findAll());
  }

}
