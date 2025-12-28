package com.example.demo.repository;

import com.example.demo.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository
        extends JpaRepository<UserAccount, Long> {

    // ✅ REQUIRED by tests & AuthService
    Optional<UserAccount> findByEmail(String email);
}
