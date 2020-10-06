package com.kingsonthegineus.hrservice.resource;


import com.kingsonthegineus.hrservice.models.Employee;
import com.kingsonthegineus.hrservice.models.EmployeesList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hr")
public class HrResource {

    List<Employee> employees = Arrays.asList(
            new Employee("E1", "Kindton", "Munonye", "MediTech"),
            new Employee("E2", "Lila", "Hardcastle", "Surgery"),
            new Employee("E3", "Solace", "Chucks", "Dentistry")
    );

    @RequestMapping("/employees")
    public EmployeesList getEmployees() {
        EmployeesList employeesList = new EmployeesList();
        employeesList.setEmployees(employees);
        return employeesList;
    }

    @RequestMapping("/employees/{Id}")

    public Employee getEmployeeById(@PathVariable("Id") String Id) {
        Employee e = employees.stream()
                .filter(employee -> Id.equals(employee.getId()))
                .findAny()
                .orElse(null);
        return e;
    }
}
