package com.rom.menshenapi.controller;

import java.net.URI;
import java.util.List;

import com.rom.menshenapi.model.Employee;
import com.rom.menshenapi.service.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeService service;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok().body(service.getEmployees());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployees(@PathVariable long id) {
        return ResponseEntity.ok().body(service.getEmployee(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = service.createEmployee(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedEmployee.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        service.updateEmployee(id, employee);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable long id) {
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}
