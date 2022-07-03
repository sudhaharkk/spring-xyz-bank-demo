package com.xyzbank.retail.model;

/*
* This is TopupAccount domain class
* @author  Sudhahar Vaithilingam
* @version 1.0
* @since   2022-07-01 
*/

public class TopupAccount {

	private String name;
	private double amount;

	/**
	 * @return current topup customer name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name to set name(customer name)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return pay amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * 
	 * @param pay amount to set amount
	 */

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
