package dev.kuhaneck.services;

import dev.kuhaneck.DAOS.ApplicationDAO;
import dev.kuhaneck.DAOS.EmployeeDAO;
import dev.kuhaneck.entities.Application;
import dev.kuhaneck.entities.Employee;

import java.util.List;

public class EmployeeService {

    private ApplicationDAO applicationDAO;

    private EmployeeDAO employeeDAO;



    public EmployeeService(EmployeeDAO employeeDAO, ApplicationDAO applicationDAO){
        this.employeeDAO = employeeDAO;
        this.applicationDAO = applicationDAO;

    }

    public List<Application> getEmployeesApps(int id){

        return applicationDAO.getAllByEIN(id);


    }

    public Application createNewApp(Application app){

        return applicationDAO.createNew(app);

    }
    public Employee login(String username, String password) {
        Employee employee = employeeDAO.getEmployeeByUsername(username);
        if (employee.getPassword().equals(password)) {
            System.out.println("logged in");
            return  employee;
        } else {
            System.out.println("whoops");
        }
        return null;

    }



}
