package com.visa.prj.client;

import com.visa.prj.entity.Account;

public class AccountClient {
	public static void main(String[] args) {
		Account rahulAcc = new Account();
		Account swethaAcc = new Account("SB120");
		rahulAcc.deposit(4500.00); // evaluates to deposit(rahulAcc, 4500.00) - optimization
		swethaAcc.deposit(6780.00);
		
		System.out.println(rahulAcc.getBalance());
		System.out.println(swethaAcc.getBalance());
		
		Account smithaAcc = new Account("SB120");
		smithaAcc.deposit(6780.00);
		
		System.out.println(Account.getCount());
		Account other = smithaAcc;
		System.out.println(Account.getCount());

		if( other == smithaAcc) {
			System.out.println("Both are same [other == smithaAcc]");
		}

		if( swethaAcc == smithaAcc) {
			System.out.println("Both are same [other == smithaAcc]");
		}
		if(swethaAcc.equals(smithaAcc)) {
			System.out.println("both are similar [swethaAcc.equals(smithaAcc)]");
		}
		
	}
}
