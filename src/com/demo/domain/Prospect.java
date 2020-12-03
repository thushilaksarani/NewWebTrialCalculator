package com.demo.domain;

//import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Prospect {
	String fName, lName, nic;
	double loanAmt, InterestRate, installmentVal;
	int repayPeriod, id; 
	Date date;
	ResultSet r;
	
	/*public Prospect(String fName) {
		this.fName = fName;
	}*/
	
	public Prospect() {
		
	}
	
	public Prospect(int id, String fName, String lName, String nic, double loanAmt, int repayPeriod, double interestRate,
			double installmentVal, Date date) {
		this.id=id;
		this.fName = fName;
		this.lName = lName;
		this.nic = nic;
		this.loanAmt = loanAmt;
		this.repayPeriod = repayPeriod;
		this.InterestRate = interestRate;
		this.installmentVal = installmentVal;
		this.date=date;
	}
	
	public Prospect( String fName, String lName, String nic, double loanAmt, int repayPeriod, double interestRate,
			double installmentVal, Date date) {
		this.fName = fName;
		this.lName = lName;
		this.nic = nic;
		this.loanAmt = loanAmt;
		this.repayPeriod = repayPeriod;
		this.InterestRate = interestRate;
		this.installmentVal = installmentVal;
		this.date=date;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public double getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(double loanAmt) {
		this.loanAmt = loanAmt;
	}

	public int getRepayPeriod() {
		return repayPeriod;
	}

	public void setRepayPeriod(int repayPeriod) {
		this.repayPeriod = repayPeriod;
	}

	public double getInterestRate() {
		return InterestRate;
	}

	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}

	public double getInstallmentVal() {
		return installmentVal;
	}

	public void setInstallmentVal(double installmentVal) {
		this.installmentVal = installmentVal;
	}
	String name;
	public void setResult(ResultSet r) {
		
		this.r=r;
		/*try {
			while (r.next()) {
				name=r.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	*/
	}
	
	public void getResult() {
		try {
			while (r.next()) {
				name=r.getString(1);
				//System.out.println(r.getInt(1)+"	"+r.getString(2)+"	"+r.getString(3)+"	"+r.getString(4)+"	"+r.getDouble(5)+"	"+r.getInt(6)+"	"+r.getDouble(7)+"	"+r.getDouble(8)+"  "+r.getDate(9)	);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(name);
		//return r;
	}
	
}
