package com.demo.service;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculation {
	
	static double instalmentVal;
	
	public static double calInstalmentVal(double loanAmt, double interestRate, int repayPeriod) {
		instalmentVal= (loanAmt*(interestRate/12))/(1-(Math.pow((1+interestRate/12), (-repayPeriod))));
		instalmentVal=bigDecimal(instalmentVal);
		return instalmentVal;
	}
	
	public static double bigDecimal(double val) {
		BigDecimal bd = new BigDecimal(val).setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	
	public static void calRepaySch( double loanAmt, double interestRate, int repayPeriod) {

		double interestAmt,capitalAmt;
		double capitalBalnce=loanAmt;
	
		//SetOutput.printRepaySched1(loanAmt);
		
		for(int i=1; i<=repayPeriod; i++) {
			interestAmt=capitalBalnce*interestRate/12;
			capitalAmt=instalmentVal-interestAmt;
			capitalBalnce=capitalBalnce-capitalAmt;
			
			interestAmt=bigDecimal(interestAmt);
			capitalAmt=bigDecimal(capitalAmt);
			capitalBalnce=bigDecimal(capitalBalnce);
			
			//SetOutput.printRepaySched2(i, instalmentVal, interestAmt, capitalAmt, capitalBalnce);
			
		}
	}
	

}
