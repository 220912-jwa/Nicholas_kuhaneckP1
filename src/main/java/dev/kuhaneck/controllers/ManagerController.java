package dev.kuhaneck.controllers;



import dev.kuhaneck.entities.ManagerApp;
import dev.kuhaneck.services.ManagerService;
import io.javalin.http.Context;


public class ManagerController {

    private ManagerService managerService;

    public ManagerController(ManagerService managerService){
        this.managerService = managerService;
    }

    public void getAllApplications(Context ctx){

        ctx.status(200);
        ctx.json(managerService.getAllApplications());

    }
    public void submitNewManagerApp(Context ctx){
      ManagerApp managerApp = ctx.bodyAsClass(ManagerApp.class);

      ManagerApp myApp = managerService.createNewApp(managerApp);
        System.out.println(myApp);

      ctx.json(myApp);



    }

}
