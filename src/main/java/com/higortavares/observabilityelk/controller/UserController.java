package com.higortavares.observabilityelk.controller;

import com.higortavares.observabilityelk.model.User;
import com.higortavares.observabilityelk.service.UserService;
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
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> save(@RequestBody User user) {
    userService.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

 @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> findAll() {
    return ResponseEntity.ok(userService.findAll());
  }

}
