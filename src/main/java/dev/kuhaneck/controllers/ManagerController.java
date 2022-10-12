package dev.kuhaneck.controllers;


import dev.kuhaneck.entities.Manager;
import dev.kuhaneck.entities.ManagerApp;
import dev.kuhaneck.services.ManagerService;
import io.javalin.http.Context;


public class ManagerController {

    private ManagerService managerService;

    public ManagerController(ManagerService managerService){
        this.managerService = managerService;
    }

    public void getAllApplications(Context ctx){
        Manager manager = ctx.sessionAttribute("loggedInManager");
        ctx.status(200);
        ctx.json(managerService.getAllApplications());

    }
    public void submitNewApp(Context ctx){
        ManagerApp mapp = ctx.bodyAsClass(ManagerApp.class);
        Manager manager = ctx.sessionAttribute("loggedInManager");
        ManagerApp managerApp = managerService.createNewApp(mapp,manager);



    }

}
