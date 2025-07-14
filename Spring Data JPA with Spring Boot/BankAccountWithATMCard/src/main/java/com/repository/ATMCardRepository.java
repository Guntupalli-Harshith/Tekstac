package com.repository;

import com.bean.ATMCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ATMCardRepository extends JpaRepository<ATMCard, String>{
}