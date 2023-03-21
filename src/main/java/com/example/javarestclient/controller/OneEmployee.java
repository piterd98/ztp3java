package com.example.javarestclient.controller;

import com.example.javarestclient.model.Employee;
import com.example.javarestclient.service.EmployeesService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RoutePrefix;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.springframework.cglib.core.TypeUtils.add;

@Route("chuj/:employeeId")
public class OneEmployee extends VerticalLayout implements BeforeEnterObserver {

    private EmployeesService service;
    private Integer employeeId;
    @Autowired
    public OneEmployee(EmployeesService service)  {
        this.service = service;
        var grid = new Grid<>(Employee.class);

        grid.setItems(service.getEmployeeById(Integer.parseInt("1")));

        add(grid);

    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        this.employeeId = Integer.valueOf(event.getRouteParameters().get("employeeId").get());
    }

}
