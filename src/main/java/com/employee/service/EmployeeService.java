package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.salary.IdNotFoundException;
import com.employee.salary.SalaryNotFoundException;
@Service
public class EmployeeService {
@Autowired
EmployeeDao ed; 
	public String setAllData(List<Employee> a) {
		return ed.setAllData(a) ;
	}
	public List<Employee> getAllData() {
		return ed.getAllData();
	}
	public String setData(Employee a) {
		return ed.setData(a);
	}
	public Employee getData(int a) {
		return ed.getData(a);
	}
	
	
	public String setAllDataHandling(List<Employee> a) throws SalaryNotFoundException {
		List<Employee> aa=a.stream().filter(x->x.getSalary()>50000).toList();
		if(aa.isEmpty()) {
		
		throw new SalaryNotFoundException("unvalid salary");
		}
	
		else {
			return ed.setAllDataHandling(aa);
			
		}
		}
	public Employee getIdNotFoundEx(int a)throws IdNotFoundException {
		return ed.getIdNotFoundEx(a);
	}

}
