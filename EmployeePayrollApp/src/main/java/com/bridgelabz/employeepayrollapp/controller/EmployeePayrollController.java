package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    // curl localhost:8080/employeepayrollservice -w "\n"
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successfull", empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    // curl localhost:8080/employeepayrollservice/get/{empId} -w "\n"
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") long empId) {
        List<EmployeePayrollData> empDataList = null;
        Optional <EmployeePayrollData> empData = null;
        empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successfull ", empData);
        return  new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    // curl -X POST -H "Content-Type: application/json" -d
    // '{"name": "neha","salary":3000}' "http://localhost:8080/employeepayrollservice/create" -w "\n"
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(
                            @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return  new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //curl -X PUT -H "Content-Type: application/json" -d '{"name": "neha","salary": 3000}'
    //"http://localhost:8080/employeepayrollservice/update" -w "\n"
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") long empId,
            @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
        return  new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //curl -X DELETE -H "Content-Type: application/json"
    //localhost:8080/employeepayrollservice/delete/1 -w "\n"
    @DeleteMapping("delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") long empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id : " +empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
