package com.xyzbank.retail.service;

import com.xyzbank.retail.model.Account;
import com.xyzbank.retail.model.PayAccount;
import com.xyzbank.retail.model.TopupAccount;

/*
 * Interface for XxzBankService
 * @author  Sudhahar
 * @version 1.0
 * @since   2022-07-01 
 */

public interface XxzBankService {
	/*
	 * To find customer details to pass by name
	 */
	public Account findbyName(String name);

	/*
	 * Top-up the customer and returns updated account details
	 */
	public Account topup(TopupAccount topupAccount);

	/*
	 * pay to customer and returns updated account details
	 */
	public Account pay(PayAccount payAccount);

	/*
	 * updates the in memory account map
	 */
	public void updateAccounts(Account account);

}
