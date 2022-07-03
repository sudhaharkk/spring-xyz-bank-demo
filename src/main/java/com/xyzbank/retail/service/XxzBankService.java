package com.xyzbank.retail.service;

import java.util.List;

import com.xyzbank.retail.model.Account;
import com.xyzbank.retail.model.PayAccount;
import com.xyzbank.retail.model.TopupAccount;

/*
* @author  Sudhahar Vaithilingam
* @version 1.0
* @since   2022-07-01 
*/

public interface XxzBankService {

	public Account findbyName(String name);

	public Account topup(TopupAccount topupAccount);
	
	public Account pay(PayAccount payAccount);
	
	public void  updateAccounts(Account account);

}
