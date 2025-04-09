package com.demo.userservice.service;

import com.demo.userservice.entity.ServiceUser;
import com.demo.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long add(ServiceUser serviceUser) {

        return userRepository.save(serviceUser).getId();
    }

    @Override
    public List<ServiceUser> list() {
        return userRepository.findAll();
    }
}
