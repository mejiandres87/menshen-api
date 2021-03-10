package com.rom.menshenapi.service;

import java.util.ArrayList;
import java.util.List;

import com.rom.menshenapi.model.Employee;
import com.rom.menshenapi.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDBService implements IEmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        repository.findAll().forEach(employees::add);
        return employees;
    }

    @Override
    public Employee getEmployee(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void updateEmployee(long id, Employee employee) {
        employee.setId(id);
        repository.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        repository.deleteById(id);
    }

}
