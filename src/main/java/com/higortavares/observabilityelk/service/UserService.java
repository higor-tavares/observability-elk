package com.higortavares.observabilityelk.service;

import com.higortavares.observabilityelk.model.User;
import com.higortavares.observabilityelk.repository.UserRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public void save(User user) {
    try {
      userRepository.save(user);
      log.info("Usuário {} criado com sucesso!", user);
    } catch (Exception e) {
      log.error("Ocorreu uma falha ao salvar o usuario {} : {}", user, e.getMessage());
      throw  new RuntimeException("Erro ao salvar o usuário");
    }
  }
  public List<User> findAll() {
    log.info("listando usuarios ...");
    return  userRepository.findAll();
  }
}
