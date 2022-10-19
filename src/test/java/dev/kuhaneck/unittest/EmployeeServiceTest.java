package dev.kuhaneck.unittest;

import dev.kuhaneck.DAOS.ApplicationDAO;
import dev.kuhaneck.DAOS.EmployeeDAO;
import dev.kuhaneck.DAOS.ManagerDAO;
import dev.kuhaneck.entities.Application;
import dev.kuhaneck.entities.Employee;
import dev.kuhaneck.entities.Manager;
import dev.kuhaneck.services.EmployeeService;
import dev.kuhaneck.services.LoginService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @InjectMocks
    private static EmployeeService employeeService;



    @Mock
    private static EmployeeDAO mockEmployeeDAO;
    @Mock
    private static ApplicationDAO mockApplicationDAO;
    @Mock
    private Employee mockEmployeeWithGoodCreds;

    @Mock
    private List<Application> applicationList;




    @Mock
    private Application mockApp;


    @BeforeAll
    public static void setup() {
        mockEmployeeDAO = new EmployeeDAO();
        mockApplicationDAO = new ApplicationDAO();
        employeeService = new EmployeeService(mockEmployeeDAO, mockApplicationDAO);
    }

    @BeforeEach
    public void mockUsersBeforeEach() {
        mockEmployeeWithGoodCreds = new Employee(
                2,
                "Steven",
                "King",
                "Scaryman",
                "password",
                1000

        );

      mockApp = new Application(
              1,
              "10/10/2022",
              "10/15/2022",
              "location",
              "status",
              "1100",
              "description",
              125,
              "work relation string",
              1,
              1,
              mockEmployeeWithGoodCreds

      );
      applicationList = new ArrayList<>(Arrays.asList(mockApp));



    }

    @Test
    public void createAppTest(){
        when(mockApplicationDAO.createNew(mockApp)).thenReturn(mockApp);
        Application app = employeeService.createNewApp(mockApp);

        Assertions.assertNotNull(app);   }

    @Test
    public void getAllForEmployeeTest(){
        when(mockApplicationDAO.getAllByEIN(mockEmployeeWithGoodCreds.getEmployeeId())).thenReturn(applicationList);
        List<Application> applications = employeeService.getEmployeesApps(mockEmployeeWithGoodCreds.getEmployeeId());

        Assertions.assertNotNull(applications);

    }

}
