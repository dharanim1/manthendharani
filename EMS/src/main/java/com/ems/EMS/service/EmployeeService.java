package com.ems.EMS.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ems.EMS.model.Employee;
 
@Service
public class EmployeeService {
	@Autowired
	private Employee employee;
	public void printEmpDetails() {
		System.out.println("Employee Details: " + employee);
	}
	public double calAnnualSalary() {
		return employee.getSalary()*12;
	}
	public List<String> getEmployeeSkills(){
		return employee.getSkills();
	}

 
	
}