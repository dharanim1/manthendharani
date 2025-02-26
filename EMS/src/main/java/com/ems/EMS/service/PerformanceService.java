package com.ems.EMS.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ems.EMS.model.Performance;
 
@Service
public class PerformanceService {
	@Autowired
	private Performance performance;
	public List<String> displayProjectList() {
		return performance.getProjectsHandled();
	}
	public boolean IsEligibleForProject() {
		if(performance.getRating() > 3.5) {
			return true;
		}
		return false;
	}
}