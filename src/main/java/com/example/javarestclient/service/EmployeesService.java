package com.example.javarestclient.service;

import com.example.javarestclient.model.Employee;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class EmployeesService {

    public EmployeesService() {

    }

    public Map<String,Employee> getEmployees() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Map<String,Employee>> response = restTemplate
                .exchange("http://127.0.0.1:5000/employees", HttpMethod.GET, null,  new ParameterizedTypeReference<Map<String,Employee>>() {
                });

        return response.getBody();
    }

    public Employee getEmployeeById(int id) {
        String url = "/employee" + id;

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Employee> response = restTemplate
                .exchange("http://127.0.0.1:5000/employee/" + id, HttpMethod.GET, null,  new ParameterizedTypeReference<Employee>() {
                });
        return response.getBody();
    }
}
