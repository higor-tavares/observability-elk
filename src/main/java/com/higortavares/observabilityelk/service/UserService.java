package com.higortavares.observabilityelk.service;

import com.higortavares.observabilityelk.model.User;
import com.higortavares.observabilityelk.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public void save(User user) {
    userRepository.save(user);
  }
  public List<User> findAll() {
    return  userRepository.findAll();
  }
}
