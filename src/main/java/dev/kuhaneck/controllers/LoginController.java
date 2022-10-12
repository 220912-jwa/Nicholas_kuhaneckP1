package dev.kuhaneck.controllers;

import dev.kuhaneck.entities.Employee;
import dev.kuhaneck.entities.Manager;
import dev.kuhaneck.services.LoginService;
import io.javalin.http.Handler;

public class LoginController {

    private LoginService loginService;


    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    public Handler employeeLogin = ctx->{
        Employee e = ctx.bodyAsClass(Employee.class);
        Employee authenticatedEmployee = loginService.login(e.getUsername(),e.getPassword());
        ctx.sessionAttribute("loggedInEmployee", authenticatedEmployee);

        if(authenticatedEmployee != null){
            ctx.status(200);
            ctx.json(authenticatedEmployee);
        }

    };


    public Handler managerLogin = ctx->{
        Manager m = ctx.bodyAsClass(Manager.class);
        Manager authenticatedManager = loginService.mLogin(m.getUsername(),m.getPassword());
        ctx.sessionAttribute("loggedInManager", authenticatedManager);
        if(authenticatedManager != null){
            ctx.status(200);
            ctx.json(authenticatedManager);
        }else{
            ctx.status(400);
            System.out.println("whoops");
        }
    };
}
