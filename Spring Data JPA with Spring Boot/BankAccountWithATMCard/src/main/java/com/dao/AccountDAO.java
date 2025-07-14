package com.dao;

import java.util.List;

import com.bean.Account;
import com.repository.AccountRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class AccountDAO {
    
    Logger logger = LoggerFactory.getLogger(AccountDAO.class);
    
    @Autowired
    private AccountRepository accountRepository;
	
	public void openAccount(Account account) {
		//fill code
		accountRepository.save(account);
		logger.info("Account with id {} added successfully", account.getAccountNumber());
	}
	
	public List<Account> retrieveAccountBasedOnCardType(String cardType){
		//fill code
		List<Account> list = accountRepository.findByAtmCardCardType(cardType);
		if(list.isEmpty()) {
		    logger.error("No account with this card type {}", cardType);
		} else{
		    logger.info("Account details with card type {} retrieved successfully", cardType);
		}
		return list;
	}
}