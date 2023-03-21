package com.example.javarestclient;

import com.example.javarestclient.rest.Employee;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class EmployeesList extends VerticalLayout {
    @Autowired
    public EmployeesList(EmployeesService service) {
        var grid = new Grid<>(Employee.class);
        grid.setItems(service.getEmployees());

        add(grid);

    }
}
