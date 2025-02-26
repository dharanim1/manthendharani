package com.ems.EMS.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.ems.EMS")
@PropertySource("classpath:application.properties")
public class EmsAppConfig {

    // Address configuration
    @Value("${address.street}")
    private String street;
    @Value("${address.city}")
    private String city;
    @Value("${address.state}")
    private String state;
    @Value("${address.zipCode}")
    private String zipCode;

    @Bean
    public Address address() {
        Address address = new Address();
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);
        address.setZipcode(zipCode);
        return address;
    }

    // Department configuration
    @Value("${department.id}")
    private int deptId;
    @Value("${department.name}")
    private String deptName;

    @Bean
    public Department department() {
        Department department = new Department();
        department.setDeptId(deptId);
        department.setDeptName(deptName);
        return department;
    }

    // Employee skills configuration
    @Value("${employee.skills}")
    private String skillsString;

    @Bean
    public List<String> skills() {
        return Arrays.asList(skillsString.split(","));
    }

    // Employee configuration
    @Value("${employee.id}")
    private int empId;
    @Value("${employee.name}")
    private String empName;
    @Value("${employee.email}")
    private String empEmail;
    @Value("${employee.phone}")
    private String empPhone;
    @Value("${employee.salary}")
    private double empSalary;
    @Value("${employee.designation}")
    private String empDesignation;

    @Bean
    public Employee employee() {
        Employee employee = new Employee();
        employee.setId(empId);
        employee.setName(empName);
        employee.setEmail(empEmail);
        employee.setPhone(empPhone);
        employee.setSalary(empSalary);
        employee.setDesignation(empDesignation);
        employee.setAddress(address());
        employee.setDepartment(department());
        employee.setSkills(skills());
        return employee;
    }

    // Performance configuration
    @Value("${performance.employeeid}")
    private int performanceEmpId;
    @Value("${performance.rating}")
    private double performanceRating;
    @Value("${performance.feedback}")
    private String performanceFeedback;
    @Value("${performance.projectsHandled}")
    private String projecthandled;
    @Value("${performance.eligibleForPromotion}")
    private boolean isEligibleForPromotion;

    @Bean
    public List<String> projectsHandled() {
        return Arrays.asList(projecthandled.split(","));
    }

    @Bean
    public Performance performance() {
        Performance performance = new Performance();
        performance.setEmployeeId(performanceEmpId);
        performance.setFeedback(performanceFeedback);
        performance.setProjectsHandled(projectsHandled());
        performance.setRating(performanceRating);
        performance.setEligibleForPromotion(isEligibleForPromotion);
        return performance;
    }

    // HR configuration
    @Bean
    public Map<Integer, Employee> empRecords() {
        Map<Integer, Employee> records = new HashMap<>();
        records.put(empId, employee());
        return records;
    }

    @Bean
    public HR hr() {
        HR hr = new HR();
        hr.setEmployeeRecords(empRecords());
        return hr;
    }

    // Payroll configuration
    @Value("${payroll.employeeId}")
    private int payrollEmpId;
    @Value("${payroll.baseSalary}")
    private double baseSalary;
    @Value("${payroll.bonuses}")
    private double bonuses;
    @Value("${payroll.deductions}")
    private double deductions;

    @Bean
    public Payroll payroll() {
        Payroll payroll = new Payroll();
        payroll.setEmployeeId(payrollEmpId);
        payroll.setBaseSalary(baseSalary);
        payroll.setBonuses(bonuses);
        payroll.setDeductions(deductions);
        return payroll;
    }
}
