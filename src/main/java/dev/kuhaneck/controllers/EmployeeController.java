package dev.kuhaneck.controllers;


import dev.kuhaneck.entities.Application;
import dev.kuhaneck.entities.Employee;
import dev.kuhaneck.services.EmployeeService;
import io.javalin.http.Context;

public class EmployeeController {

    private EmployeeService employeeService;




    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;

    }

    public void getAllAppsForEmployee(Context ctx){
    Employee employee = ctx.sessionAttribute("loggedInEmployee");
      ctx.status(200);

        ctx.json(employeeService.getEmployeesApps(employee.getEmployeeId()));
    }

    public void submitNewApp(Context ctx){
        Application app = ctx.bodyAsClass(Application.class);
        Employee employee = ctx.sessionAttribute("loggedInEmployee");
        Application application = employeeService.createNewApp(app,employee);



    }

}
