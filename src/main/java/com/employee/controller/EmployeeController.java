package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.salary.IdNotFoundException;
import com.employee.salary.SalaryNotFoundException;
import com.employee.service.EmployeeService;

@RestController

public class EmployeeController {
@Autowired
	EmployeeService es;

@PostMapping(path="/setValue")
public String setData(@RequestBody Employee a) {
	return  es.setData(a);

}

@PostMapping(path="/setAllValue")
public String setAllData(@RequestBody List<Employee> a) {
	return  es.setAllData(a);
}
@GetMapping(path=("/getAllValue"))
public List<Employee> getAllData(){
	return es.getAllData();
}

@GetMapping(path=("/getValue/{a}"))
public Employee getData(@PathVariable int a){
	return es.getData(a);
}


@PostMapping(path="/setAllHandling")
public String setAllDataHandling(@RequestBody List<Employee> a) throws SalaryNotFoundException{
	return  es.setAllDataHandling(a);
}


@GetMapping(path=("/getIdNotFound/{a}"))
public Employee getIdNotFoundEx(@PathVariable int a) throws IdNotFoundException {
	return es.getIdNotFoundEx(a);
}
}
