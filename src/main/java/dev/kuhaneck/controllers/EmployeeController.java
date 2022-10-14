package dev.kuhaneck.controllers;


import dev.kuhaneck.entities.Application;

import dev.kuhaneck.services.EmployeeService;
import io.javalin.http.Context;

public class EmployeeController {

    private EmployeeService employeeService;




    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;

    }

    public void getAllAppsForEmployee(Context ctx){

        int id = Integer.parseInt(ctx.pathParam("ID"));
      ctx.status(200);

        ctx.json(employeeService.getEmployeesApps(id));
    }

    public void submitNewApp(Context ctx){
        Application app = ctx.bodyAsClass(Application.class);

        Application application = employeeService.createNewApp(app);

        ctx.json(application);



    }

}
