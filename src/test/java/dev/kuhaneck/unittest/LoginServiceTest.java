package dev.kuhaneck.unittest;

import dev.kuhaneck.DAOS.EmployeeDAO;
import dev.kuhaneck.DAOS.ManagerDAO;
import dev.kuhaneck.entities.Employee;
import dev.kuhaneck.entities.Manager;
import dev.kuhaneck.services.LoginService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {

    @InjectMocks
    private static LoginService loginService;
    @InjectMocks
    private static LoginService managerLoginService;

    @Mock
    private static EmployeeDAO mockEmployeeDAO;
    @Mock
    private static ManagerDAO mockManagerDAO;
    @Mock
    private Employee mockEmployeeWithGoodCreds;


    @Mock
    private Manager mockManagerWithGoodCred;

    @BeforeAll
    public static void setup(){
        mockEmployeeDAO = new EmployeeDAO();
        loginService = new LoginService(mockEmployeeDAO);
        mockManagerDAO= new ManagerDAO();
        managerLoginService = new LoginService(mockManagerDAO);
    }


    @BeforeEach
    public void mockUsersBeforeEach(){
        mockEmployeeWithGoodCreds = new Employee(
                2,
                "Steven",
                "King",
                "Scaryman",
                "password",
                1000

        );

        mockManagerWithGoodCred = new Manager(
                1,
                "Jake",
                "Doe",
                "username",
                "password",
                1000
        );

    }
    @Test
    public void loginTest(){
        when(mockEmployeeDAO.getEmployeeByUsername(mockEmployeeWithGoodCreds.getUsername())).thenReturn(mockEmployeeWithGoodCreds);

        Employee e = loginService.login(mockEmployeeWithGoodCreds.getUsername(),mockEmployeeWithGoodCreds.getPassword());

        Assertions.assertNotNull(e);

    }
    @Test
    public void managerLoginTest(){
        when(mockManagerDAO.getManagerByUsername(mockManagerWithGoodCred.getUsername())).thenReturn(mockManagerWithGoodCred);

        Manager m = managerLoginService.mLogin(mockManagerWithGoodCred.getUsername(), mockManagerWithGoodCred.getPassword());

        Assertions.assertNotNull(m);
    }




}
