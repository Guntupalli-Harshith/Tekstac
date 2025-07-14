package com.controller;

import java.util.List;

import com.bean.Account;
import com.bean.CurrentAccount;
import com.bean.SavingsAccount;
import com.dao.AccountDAO;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AccountController {

    @Autowired
    private AccountDAO accountDao;
	
	@PostMapping("/openAccount/CURR")
	public void openAccount(@RequestBody CurrentAccount account) {
		//fill code
		accountDao.openAccount(account);
	}
	
    @PostMapping("/openAccount/SAV")
	public void openAccount(@RequestBody SavingsAccount account) {
		//fill code
    	accountDao.openAccount(account);	
	}
	
    @GetMapping("/retrieveAccountBasedOnCardType/{cardType}")
	public List<Account> retrieveAccountBasedOnCardType(@PathVariable String cardType){
		//fill code
		return accountDao.retrieveAccountBasedOnCardType(cardType);
	}
}