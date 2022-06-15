package com.higortavares.observabilityelk.controller;

import com.higortavares.observabilityelk.model.User;
import com.higortavares.observabilityelk.service.UserService;
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

@Controller
@RequestMapping("user")
@Slf4j
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> save(@RequestBody User user) {
    userService.save(user);
    log.info("Usuario criado com sucesso!");
    return ResponseEntity.status(HttpStatus.CREATED).body("Criado com sucesso!");
  }

 @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> findAll() {
    log.info("listando usuarios ...");
    return ResponseEntity.ok(userService.findAll());
  }

}
