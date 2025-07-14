package com.dao;

import com.bean.ATMCard;
import com.bean.Account;
import com.repository.ATMCardRepository;
import com.repository.AccountRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ATMCardDAO {
    
    Logger logger = LoggerFactory.getLogger(ATMCardDAO.class);
    
    @Autowired
    private ATMCardRepository atmCardRepository;
    
    @Autowired
    private AccountRepository accountRepository;
    
	public void issueATMCardToAccount(int accountNumber, ATMCard atmCardObject) {
			//fill code
			Account account = accountRepository.findById(accountNumber).orElse(null);
			if(account == null || account.getAtmCard() != null){
			    logger.error("ATM card not issued to account number {}", accountNumber);
			    return;
			}
			atmCardObject.setAccount(account);
			account.setAtmCard(atmCardObject);
			accountRepository.save(account);
			logger.info("ATM card successfully issued to account number {}", accountNumber);
	}
}