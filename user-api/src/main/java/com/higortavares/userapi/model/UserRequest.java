package com.higortavares.userapi.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class UserRequest {
  private String email;
  private String nome;

  public User userEntity() {
   return User.builder()
       .name(nome)
       .email(email)
       .createdAt(LocalDateTime.now())
       .build();
  }
}
