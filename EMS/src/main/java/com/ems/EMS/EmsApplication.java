package com.ems.EMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ems.EMS.model.Employee;
import com.ems.EMS.model.EmsAppConfig;
import com.ems.EMS.service.EmployeeService;
import com.ems.EMS.service.HRService;
import com.ems.EMS.service.PayrollService;
import com.ems.EMS.service.PerformanceService;

@SpringBootApplication
public class EmsApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(EmsAppConfig.class);

        // Employee service details
        System.out.println("-------------- Employee Service details ------------------");
        EmployeeService empService = context.getBean(EmployeeService.class);
        System.out.println("Annual salary: " + empService.calAnnualSalary());
        empService.printEmpDetails();

        // HR service details
        System.out.println("-------------- HR Service details ------------------");
        HRService hrService = context.getBean(HRService.class);
        System.out.println(hrService.getEmpById(2));

        // Payroll service details
        System.out.println("-------------- Payroll Service details ------------------");
        PayrollService payrollService = context.getBean(PayrollService.class);
        System.out.println(payrollService.calAnnualbonus());
        System.out.println(payrollService.calAnnualdeduction());
        payrollService.printPayrollDetails();

        // Performance service details
        System.out.println("-------------- Performance Service details ------------------");
        PerformanceService performanceService = context.getBean(PerformanceService.class);
        System.out.println(performanceService.IsEligibleForProject());
        performanceService.displayProjectList();
    }
}
