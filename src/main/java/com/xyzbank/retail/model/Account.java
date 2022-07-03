package com.xyzbank.retail.model;

/*
* This is Account domain class
* @author  Sudhahar
* @version 1.0
* @since   2022-07-01 
*/

public class Account {

	private String name;
	private double balance;
	private String oweTo;
	private double oweToAmount;
	private String oweFrom;
	private double oweFromAmount;

	/**
	 * @return current name
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
	 * @return current balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * 
	 * @param balance to set balance(customer balance)
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return oweTo(yet to be paid in person)
	 */
	public String getOweTo() {
		return oweTo;
	}

	/**
	 * 
	 * @param oweTo to set oweTo
	 */
	public void setOweTo(String oweTo) {
		this.oweTo = oweTo;
	}

	/**
	 * @return oweToAmount(yet to be paid in amounts)
	 */
	public double getOweToAmount() {
		return oweToAmount;
	}

	/**
	 * 
	 * @param oweToAmount to set oweToAmount
	 */
	public void setOweToAmount(double oweToAmount) {
		this.oweToAmount = oweToAmount;
	}

	/**
	 * @return oweFrom(yet to be receive in person)
	 */
	public String getOweFrom() {
		return oweFrom;
	}

	/**
	 * 
	 * @param oweFrom to set oweFrom
	 */
	public void setOweFrom(String oweFrom) {
		this.oweFrom = oweFrom;
	}

	/**
	 * @return oweFrom(yet to be receive in amount)
	 */
	public double getOweFromAmount() {
		return oweFromAmount;
	}

	/**
	 * 
	 * @param oweFromAmount to set oweFromAmount
	 */
	public void setOweFromAmount(double oweFromAmount) {
		this.oweFromAmount = oweFromAmount;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", balance=" + balance + ", oweTo=" + oweTo + ", oweToAmount=" + oweToAmount
				+ ", oweFrom=" + oweFrom + ", oweFromAmount=" + oweFromAmount + "]";
	}

}
