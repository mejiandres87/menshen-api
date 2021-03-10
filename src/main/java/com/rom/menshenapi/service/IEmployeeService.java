package com.rom.menshenapi.service;

import java.util.List;

import com.rom.menshenapi.model.Employee;

public interface IEmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee getEmployee(long id);

    void updateEmployee(long id, Employee employee);

    void deleteEmployee(long id);

}
