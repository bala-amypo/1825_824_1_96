package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.UserAccount;
import java.util.List;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
    List<userAccount> findByEmail(String email);
}