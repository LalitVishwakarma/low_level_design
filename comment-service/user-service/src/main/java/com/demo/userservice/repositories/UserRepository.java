package com.demo.userservice.repositories;


import com.demo.userservice.entity.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ServiceUser, Long> {
}
