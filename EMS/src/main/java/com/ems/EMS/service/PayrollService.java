package com.ems.EMS.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ems.EMS.model.Payroll;
 
 
@Service
public class PayrollService {
	@Autowired
	private Payroll payroll;
	public double calAnnualbonus() {
		return payroll.getBonuses()*12;
	}
	public double calAnnualdeduction() {
		return payroll.getDeductions()*12;
	}
	public List<String> printPayrollDetails() {
		System.out.println("Payroll Details : " + payroll);
		return null ;
	}
 
	
 
}