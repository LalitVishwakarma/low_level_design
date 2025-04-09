package com.demo.userservice.service;

import com.demo.userservice.entity.ServiceUser;

import java.util.List;

public interface UserService {
    Long add(ServiceUser serviceUser) throws Exception;

    List<ServiceUser> list();
}
