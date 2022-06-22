package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;
import java.util.Optional;


public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployePayrollData();

    Optional<EmployeePayrollData> getEmployeePayrollDataById(long empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(long empId, EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(long empId);
}
