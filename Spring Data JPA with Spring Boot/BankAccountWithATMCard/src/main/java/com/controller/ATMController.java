package com.controller;

import com.bean.ATMCard;
import com.dao.ATMCardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ATMController {
    
    @Autowired
    private ATMCardDAO atmCardDAO;
	
	@PostMapping("/issueATMCardToAccount/{accountNumber}")
	public void issueATMCardToAccount(@PathVariable int accountNumber, @RequestBody ATMCard atmCardObjet) {
			//fill code
			atmCardDAO.issueATMCardToAccount(accountNumber, atmCardObjet);
	}
}