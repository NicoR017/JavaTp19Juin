package com.example.travelAgency.service;

import com.example.travelAgency.model.User;
import com.example.travelAgency.repository.UserRepository;
import com.example.travelAgency.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
    private UserRepository userRepository;
    @Override
    public void register(@Valid User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
