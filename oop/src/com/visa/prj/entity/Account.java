/**
 * 
 */
package com.visa.prj.entity;

/**
 * @author Administrator
 *
 *
 */
public class Account {
	private String accNo;
	private double balance;
	private static int count;
	
	public Account() {
		super();
		count++;
	}

	public Account(String accNo) {
		super();
		this.accNo = accNo;
		count++;
	}

	/**
	 * This method is to credit amount into account
	 * 
	 * @param amt amount to be credited
	 */
	public void deposit(double amt){ // evaluates to deposit(Account this, double amt)
		balance += amt; // evaluates to this.balance += amt
	}
	
	/*
	 * This method returns current account balance
	 */
	public double getBalance() {
		return balance;
	}
	
	public String getAccno() {
		return this.accNo;
	}
	
	public boolean equals(Object obj) {
		Account other = (Account) obj;
        return (this.accNo.equals(other.accNo));
    }
	
	public static int getCount() {
		return count;
	}
 }
