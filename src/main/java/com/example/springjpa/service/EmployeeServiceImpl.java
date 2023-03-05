package com.example.springjpa.service;


import com.example.springjpa.dao.EmployeeRepository;
import com.example.springjpa.entity.Employee;
import org.hibernate.sql.results.graph.embeddable.internal.EmbeddableFetchImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = null;
        Optional<Employee> emp = employeeRepository.findById(id);
        if (emp.isPresent()) {
            employee = emp.get();
        }
        return employee;

    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}