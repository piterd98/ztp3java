package com.example.javarestclient;

import com.example.javarestclient.rest.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeesService {

    private final WebClient webClient;
    public EmployeesService(WebClient.Builder builder) {
        webClient = builder.baseUrl("http://127.0.0.1:5000/").build();
    }

    public Employee[] getEmployees() {
        return webClient
                .get()
                .uri("/employees")
                .retrieve()
                .bodyToMono(Employee[].class).block();
    }

    public Employee getEmployeeById(int id) {
        String url = "/employee" + id;
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Employee.class).block();
    }
}
