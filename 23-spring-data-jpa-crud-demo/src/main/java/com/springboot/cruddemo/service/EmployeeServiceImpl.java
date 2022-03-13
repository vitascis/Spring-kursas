package com.springboot.cruddemo.service;

import com.springboot.cruddemo.dao.EmployeeRepository;
import com.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
@Autowired   //optional
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

    this.employeeRepository = employeeRepository;
    }

    @Override

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override

    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if(result.isPresent()) {
            employee = result.get();
        }else  {
//            we didn't find employee
            throw new RuntimeException("did't find employee id: " + id);
        }
    return employee;
    }

    @Override

    public void save(Employee employee) {
employeeRepository.save(employee);
    }

    @Override

    public void deleteById(int id) {
employeeRepository.deleteById(id);
    }
}
