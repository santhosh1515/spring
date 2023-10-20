package com.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.salary.IdNotFoundException;
@Repository
public class EmployeeDao {
@Autowired
EmployeeRepository er;
	public String setAllData(List<Employee> a) {
		er.saveAll(a);
		return "successfully" ;
	}
	public List<Employee> getAllData() {
		return er.findAll();
	}
	public String setData(Employee a) {
		er.save(a);
		return "save successfully";
	}
	public Employee getData(int a) {
		return er.findById(a).get();
	}
	public String setAllDataHandling(List<Employee> a) {
		er.saveAll(a);
		return "success handle";
	}
	public Employee getIdNotFoundEx(int a) throws IdNotFoundException {
		return er.findById(a).orElseThrow(()->new  IdNotFoundException("not a valid id"));
	}

}
