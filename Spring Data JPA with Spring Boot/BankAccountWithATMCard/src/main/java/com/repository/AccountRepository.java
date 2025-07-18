package com.repository;

import com.bean.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByAtmCardCardType(String cardType);
}