package dev.kuhaneck.services;

import dev.kuhaneck.DAOS.ApplicationDAO;
import dev.kuhaneck.DAOS.ManagerAppDAO;
import dev.kuhaneck.DAOS.ManagerDAO;
import dev.kuhaneck.entities.Application;
import dev.kuhaneck.entities.Employee;
import dev.kuhaneck.entities.Manager;
import dev.kuhaneck.entities.ManagerApp;

import java.util.List;

public class ManagerService {


    private ManagerAppDAO managerAppDAO;
    private ApplicationDAO applicationDAO;

    private ManagerDAO managerDAO;

    public ManagerService (ManagerDAO managerDAO, ApplicationDAO applicationDAO, ManagerAppDAO managerAppDAO){
        this.managerDAO = managerDAO;
        this.managerAppDAO = managerAppDAO;
        this.applicationDAO = applicationDAO;
    }
    public List<Application> getAllApplications(){

        return applicationDAO.getAll();

    }
    public ManagerApp createNewApp(ManagerApp app, Manager manager){

        return managerAppDAO.createManagerApp(app, manager);

    }



}
