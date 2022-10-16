package dev.kuhaneck;

import dev.kuhaneck.DAOS.ApplicationDAO;
import dev.kuhaneck.DAOS.EmployeeDAO;
import dev.kuhaneck.DAOS.ManagerAppDAO;
import dev.kuhaneck.DAOS.ManagerDAO;
import dev.kuhaneck.controllers.EmployeeController;

import dev.kuhaneck.controllers.LoginController;
import dev.kuhaneck.controllers.ManagerController;
import dev.kuhaneck.services.EmployeeService;

import dev.kuhaneck.services.LoginService;
import dev.kuhaneck.services.ManagerService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class AppRunner {
    public static void main(String[] args) {

     ManagerDAO managerDAO = new ManagerDAO();
     EmployeeDAO employeeDAO = new EmployeeDAO();
     ApplicationDAO applicationDAO = new ApplicationDAO();
     ManagerAppDAO managerAppDAO = new ManagerAppDAO();

     LoginService loginService = new LoginService(employeeDAO);
     LoginService loginServiceManager = new LoginService(managerDAO);
     LoginController loginController = new LoginController(loginService);
     LoginController loginControllerManager = new LoginController(loginServiceManager);

     EmployeeService employeeService = new EmployeeService(employeeDAO, applicationDAO);
     EmployeeController ec = new EmployeeController(employeeService);
     ManagerService managerService = new ManagerService(managerDAO,applicationDAO, managerAppDAO, employeeDAO);
     ManagerController managerController = new ManagerController(managerService);


        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.addStaticFiles("/public",Location.CLASSPATH);
           }).start(8080);


        app.post("/managerLogin", loginControllerManager.managerLogin);
        app.post("/employeeLogin", loginController.employeeLogin);
        app.get("/managerHome", managerController::getAllApplications);
        app.get("/employeeHome/{ID}", ec::getAllAppsForEmployee );

        app.post("/newRequest",ec::submitNewApp);
        app.post("/newApp", managerController::submitNewManagerApp);
        app.get("/currentApp/{ID}", managerController::getAppById);

        app.post("/updateApp/{ID}/{status}", managerController::updateApp);
        app.post("/funds/{ID}/{costDeduction}", managerController::updateEmployeeFunds);


}
}