package com.xyzbank.retail.model;

/*
* This is PayAccount domain class 
* @author  Sudhahar Vaithilingam
* @version 1.0
* @since   2022-07-01 
*/

public class PayAccount {

	private String name;
	private double amount;
	private String payTo;

	/**
	 * @return current receiver
	 */
	public String getPayTo() {
		return payTo;
	}

	/**
	 * 
	 * @param receiver name to set payTo(customer name)
	 */
	public void setPayTo(String payTo) {
		this.payTo = payTo;
	}

	/**
	 * @return current sender name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param sender name to set name(customer name)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return sender amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * 
	 * @param sender amount to set amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
