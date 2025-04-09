package com.demo.comment.repositories;


import com.demo.comment.entity.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ServiceUser, Long> {
}
