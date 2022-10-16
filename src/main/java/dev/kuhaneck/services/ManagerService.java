package dev.kuhaneck.services;

import dev.kuhaneck.DAOS.ApplicationDAO;
import dev.kuhaneck.DAOS.EmployeeDAO;
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
    private EmployeeDAO employeeDAO;

    private ManagerDAO managerDAO;

    public ManagerService (ManagerDAO managerDAO, ApplicationDAO applicationDAO, ManagerAppDAO managerAppDAO, EmployeeDAO employeeDAO){
        this.managerDAO = managerDAO;
        this.managerAppDAO = managerAppDAO;
        this.applicationDAO = applicationDAO;
        this.employeeDAO = employeeDAO;

    }
    public List<Application> getAllApplications(){

        return applicationDAO.getAll();

    }
    public ManagerApp createNewApp(ManagerApp mapp){

        return managerAppDAO.createManagerApp(mapp);

    }

    public Application getAppById(int id){
        return applicationDAO.getById(id);

    }
    public void updateApp(String status, int id){

        applicationDAO.updated(status, id);
    }

    public void updateEmployeeFunds(double funds, int id){
        System.out.println(funds);
        employeeDAO.updateEmployeeFund(funds, id);

    }


}
