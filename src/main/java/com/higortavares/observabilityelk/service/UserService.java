package com.higortavares.observabilityelk.service;

import com.higortavares.observabilityelk.model.User;
import com.higortavares.observabilityelk.repository.UserRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public void save(User user){
      User userResponse = userRepository.save(user);
      MDC.put("userId", userResponse.getId().toString());
      log.info("Usuário {} criado com sucesso!", user);
  }
  public List<User> findAll() {
    log.info("listando usuarios ...");
    return  userRepository.findAll();
  }
}
