package com.kingsonthegineus.admissionsservice.service;


import com.kingsonthegineus.admissionsservice.entity.DiseasesList;
import com.kingsonthegineus.admissionsservice.entity.EmployeesList;
import com.kingsonthegineus.admissionsservice.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admissions")
public class AdmissionsResource {
    @Autowired
    private RestTemplate restTemplate;
    List<Patient> patients = Arrays.asList(

    );


    @RequestMapping("/physicians")
    public EmployeesList getPhysicians() {
        EmployeesList employeesList = restTemplate.getForObject("http://localhost:8083/hr/employees", EmployeesList.class);
        return employeesList;
    }

    @RequestMapping("/disease")
    public DiseasesList getDiseases() {
        DiseasesList diseasesList = restTemplate.getForObject("http://localhost:8084/pathology/diseases", DiseasesList.class);
        return diseasesList;
    }

    @RequestMapping("/patients")
    public List<Patient> getPatients() {
        return patients;

    }

    @PostMapping("/p")


    @RequestMapping("/patients/{Id}")
    public Patient getPatientById(@PathVariable("Id") String Id) {
        Patient p = patients.stream()
                .filter(patient -> Id.equals(patient.getId()))
                .findAny()
                .orElse(null);
        return p;

    }


}
