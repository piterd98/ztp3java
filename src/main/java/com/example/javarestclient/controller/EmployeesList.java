package com.example.javarestclient.controller;

import com.example.javarestclient.service.EmployeesService;
import com.example.javarestclient.model.Employee;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Route
public class EmployeesList extends VerticalLayout {

    private EmployeesService service;
    @Autowired
    public EmployeesList(EmployeesService service) {
        this.service = service;
        var grid = new Grid<>(Employee.class);
        List<Employee> list = new ArrayList<>();
        for (Map.Entry<String, Employee> entry : service.getEmployees().entrySet()) {
            list.add(entry.getValue());
        }
        grid.setItems(list);
        add(grid);

    }
}
