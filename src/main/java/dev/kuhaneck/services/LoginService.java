package dev.kuhaneck.services;

import dev.kuhaneck.DAOS.EmployeeDAO;
import dev.kuhaneck.DAOS.ManagerDAO;
import dev.kuhaneck.entities.Employee;
import dev.kuhaneck.entities.Manager;

public class LoginService {
    private EmployeeDAO employeeDAO;
    private ManagerDAO managerDAO;

    public LoginService(EmployeeDAO employeeDAO){

        this.employeeDAO = employeeDAO;
    }

    public LoginService(ManagerDAO managerDAO){
        this.managerDAO = managerDAO;

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


    public Manager mLogin(String username, String password){
        Manager manager = managerDAO.getManagerByUsername(username);

        if(manager.getPassword().equals(password)){

            System.out.println("logged in");
            return manager;
        }else {
            System.out.println("whoops");
        }
        return  null;

    }

}
