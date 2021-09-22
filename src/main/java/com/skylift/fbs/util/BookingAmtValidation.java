package com.skylift.fbs.util;

import java.util.HashMap;
import java.util.Map;

import com.skylift.fbs.exception.InsufficiantAmountException;

public class BookingAmtValidation {
	
	private static Map<String, Double> accountMap = new HashMap<String, Double>();
	
	static {
		accountMap.put("acc1", 18000.0);
		accountMap.put("acc2", 12000.0);
		accountMap.put("acc3", 25000.0);
		accountMap.put("acc4", 28000.0);
		accountMap.put("acc5", 5000.0);
	}
	
	
	public static boolean validateTicketAmount(String accNo, double amount) {
		if(amount>accountMap.get(accNo)) {
			throw new InsufficiantAmountException("insufficient amount");
		}else {
			return true;
		}
	}

}
