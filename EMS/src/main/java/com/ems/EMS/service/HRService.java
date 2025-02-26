package com.ems.EMS.service;
 
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ems.EMS.model.Employee;
import com.ems.EMS.model.HR;
 
@Service
public class HRService {
 
 
	
	@Autowired
	public HR hr;
	public Employee getEmpById(int empId) {
		Map<Integer, Employee> empRecords = hr.getEmployeeRecords();
		return empRecords.getOrDefault(empId, null);
	}

 
}