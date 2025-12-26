package com.example.demo.repository;
import com.example.demo.model.UserAccount;
import java.util.List;
import java.util.Optional;
public interface UserAccountRepository {
    Optional<UserAccount> findByEmail(String email);
    UserAccount save(UserAccount user);
    List<UserAccount> findAll();
}