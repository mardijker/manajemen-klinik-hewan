package com.telu_pjj.manajemen_klinik_hewan.repository;

import com.telu_pjj.manajemen_klinik_hewan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}