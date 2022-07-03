package com.xyzbank.retail.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xyzbank.retail.component.AppData;
import com.xyzbank.retail.model.Account;
import com.xyzbank.retail.model.PayAccount;
import com.xyzbank.retail.model.TopupAccount;

@Service
public class XxyBankServiceImpl implements XxzBankService {

	private final Logger log = LoggerFactory.getLogger(XxyBankServiceImpl.class);

	AppData appData;

	public XxyBankServiceImpl(AppData appData) {
		super();
		this.appData = appData;
	}


	@Override
	public Account findbyName(String name) {
		Account account = appData.getAccountMap().get(name);
		if (account == null) {
			Account acc = new Account();
			acc.setName(name);
			acc.setBalance(0L);
			updateAccounts(acc);
			log.info("New User Added !!!!!!!![{}]", acc);
			return acc;
		} else
			log.info("Existing User returned  !!!!!!!![{}]", account);
		return account;
	}

	@Override
	public Account topup(TopupAccount acc) {

		Account topUpAccount = appData.getAccountMap().get(acc.getName());
		if (topUpAccount.getOweTo() != null && !topUpAccount.getOweTo().isEmpty()) {
			Account payTo = appData.getAccountMap().get(topUpAccount.getOweTo());
			double oweAmount = topUpAccount.getOweToAmount();

			if (acc.getAmount() < oweAmount) {
				topUpAccount.setBalance(0L);
				payTo.setBalance(payTo.getBalance() + acc.getAmount());
				payTo.setOweFromAmount(payTo.getOweFromAmount() - acc.getAmount());
				topUpAccount.setOweToAmount(topUpAccount.getOweToAmount() - acc.getAmount());
				updateAccounts(payTo);
				updateAccounts(topUpAccount);
			} else {
				topUpAccount.setBalance(acc.getAmount() - oweAmount);
				topUpAccount.setOweTo(null);
				topUpAccount.setOweToAmount(0L);
				updateAccounts(topUpAccount);
				payTo.setOweFrom(null);
				payTo.setOweFromAmount(0L);
				updateAccounts(payTo);

			}
			return topUpAccount;
		}

		Account account = appData.getAccountMap().get(acc.getName());
		if (account == null) {
			log.info("User Not Found !!!!!!!![{}]", acc.getName());
			return null;
		} else {
			double amount = account.getBalance() + acc.getAmount();
			account.setBalance(amount);
			updateAccounts(account);
		}
		return account;
	}

	@SuppressWarnings("unused")
	@Override
	public Account pay(PayAccount payAccount) {
		Account payFrom = appData.getAccountMap().get(payAccount.getName());
		Account payTo = appData.getAccountMap().get(payAccount.getPayTo());

		if (payFrom == null) {
			Account acc = new Account();
			log.info("User {{}] Not Found ",payAccount.getName());
			return null;
		}
		if (payTo == null) {
			Account acc = new Account();
			log.info("Beneficiary [{}] Not Found ",payTo.getName());
			return acc;
		} else {
			double curBalance = 0;
			if (payFrom.getBalance() < 0) {
				curBalance = payAccount.getAmount();
			} else {
				curBalance = payFrom.getBalance();
			}

			double transferAmt = payAccount.getAmount();
			double bal = curBalance - transferAmt;
			if (bal <= 0) {
				payFrom.setBalance(0L);
				if (payFrom.getOweToAmount() > 0) {
					payFrom.setOweToAmount(Math.abs(payFrom.getOweToAmount() - curBalance));
					payTo.setOweFromAmount(Math.abs(payTo.getOweFromAmount() - curBalance));
				} else {
					payFrom.setOweToAmount(Math.abs(bal));
					payTo.setOweFromAmount(Math.abs(bal));
				}
				payFrom.setOweTo(payTo.getName());
				payTo.setBalance(payTo.getBalance() + curBalance);
				payTo.setOweFrom(payFrom.getName());
				updateAccounts(payTo);
				updateAccounts(payFrom);
			} else {
				if (payTo.getOweTo() != null && payTo.getOweTo().equals(payFrom.getName())) {
					if (transferAmt < payFrom.getOweFromAmount()) {
						payTo.setOweToAmount(Math.abs(payTo.getOweToAmount() - transferAmt));
						payFrom.setOweFromAmount(Math.abs(transferAmt - payFrom.getOweFromAmount()));
					} else {
						payTo.setBalance(payTo.getBalance() + Math.abs(transferAmt - payFrom.getOweFromAmount()));
						payFrom.setBalance(payFrom.getBalance() - Math.abs (transferAmt - payFrom.getOweFromAmount()));
						payTo.setOweToAmount(0L);
						payTo.setOweTo(null);
						payFrom.setOweFromAmount(0L);
						payFrom.setOweFrom(null);						
					}

				} else {
					payFrom.setBalance(bal);
					payTo.setBalance(payTo.getBalance() + transferAmt);
				}
				updateAccounts(payTo);
				updateAccounts(payFrom);
			}
		}
		return payFrom;
	}

	@Override
	public void updateAccounts(Account acc) {
		Map<String, Account> accountMap = appData.getAccountMap();
		accountMap.put(acc.getName(), acc);
		appData.setAccountMap(accountMap);

	}
}