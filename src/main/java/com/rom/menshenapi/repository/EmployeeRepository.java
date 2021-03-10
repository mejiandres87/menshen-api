package com.rom.menshenapi.repository;

import com.rom.menshenapi.model.Employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
