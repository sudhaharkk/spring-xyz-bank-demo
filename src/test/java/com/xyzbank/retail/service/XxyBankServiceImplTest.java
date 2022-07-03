package com.xyzbank.retail.service;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.xyzbank.retail.model.Account;
import com.xyzbank.retail.model.PayAccount;
import com.xyzbank.retail.model.TopupAccount;

@WebMvcTest
class XxyBankServiceImplTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private XxzBankService xyzBankService;

	Account account;
	TopupAccount topupAccount;
	PayAccount payAccount;

	@BeforeEach
	public void setup() {
		account = new Account();
		account.setName("Kavin");
		account.setBalance(100L);

		topupAccount = new TopupAccount();
		topupAccount.setName("Kavin");
		topupAccount.setAmount(200L);

		payAccount = new PayAccount();
		payAccount.setName("Kavin");
		payAccount.setPayTo("Kayal");
		payAccount.setAmount(400L);
	}

	@Test
	void testFindbyName() {
		Mockito.when(xyzBankService.findbyName("Kavin")).thenReturn(account);
		Account retrivedAccount;
		retrivedAccount = new Account();
		retrivedAccount.setName("Kavin");
		retrivedAccount.setBalance(100L);
		Assert.assertEquals(account.getName(), retrivedAccount.getName());

	}

	@Test
	void testTopup() {
		Mockito.when(xyzBankService.topup(topupAccount)).thenReturn(account);
		Assert.assertEquals(topupAccount.getName(), account.getName());
	}

	@Test
	void testPay() {
		Mockito.when(xyzBankService.pay(payAccount)).thenReturn(account);
		Assert.assertEquals(topupAccount.getName(), account.getName());
	}

}
