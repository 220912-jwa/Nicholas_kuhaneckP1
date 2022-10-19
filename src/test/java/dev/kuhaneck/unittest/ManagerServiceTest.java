package dev.kuhaneck.unittest;
import dev.kuhaneck.DAOS.ApplicationDAO;
import dev.kuhaneck.DAOS.EmployeeDAO;
import dev.kuhaneck.DAOS.ManagerAppDAO;
import dev.kuhaneck.DAOS.ManagerDAO;
import dev.kuhaneck.entities.Application;
import dev.kuhaneck.entities.Employee;
import dev.kuhaneck.entities.Manager;
import dev.kuhaneck.entities.ManagerApp;
import dev.kuhaneck.services.EmployeeService;
import dev.kuhaneck.services.LoginService;

import dev.kuhaneck.services.ManagerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.configuration.injection.MockInjection;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ManagerServiceTest {

    @InjectMocks
    private static ManagerService managerService;

    @Mock
    private static EmployeeDAO employeeDAO;
    @Mock
    private static ManagerDAO managerDAO;
    @Mock
    private static ApplicationDAO applicationDAO;
    @Mock
    private List<Application> applicationList;
    @Mock
    private ManagerApp managerApp;
    @Mock
    private static ManagerAppDAO managerAppDAO;
    @Mock
    private Application mockApplication;
    @Mock
    private ManagerApp mockManagerApp;
    @Mock
    private Employee mockEmployee;
    @Mock
    private Manager mockManager;


    @BeforeAll
    public static void setUp(){
        employeeDAO = new EmployeeDAO();
        managerDAO = new ManagerDAO();
        applicationDAO = new ApplicationDAO();
        managerAppDAO = new ManagerAppDAO();
        managerService = new ManagerService(managerDAO,applicationDAO,managerAppDAO,employeeDAO);

    }

    @BeforeEach
    public void mockDataSetUps(){
        mockEmployee = new Employee(
                2,
                "Steven",
                "King",
                "Scaryman",
                "password",
                1000

        );

        mockApplication = new Application(
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
                mockEmployee

        );
        applicationList = new ArrayList<>(Arrays.asList(mockApplication));

        mockManagerApp = new ManagerApp(   1,
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
                mockManager);

    }


    @Test
    public void managerGetAllAppsTest(){

        when(applicationDAO.getAll()).thenReturn(applicationList);

        List<Application> applications = managerService.getAllApplications();

        Assertions.assertNotNull(applications);


    }
    @Test
    public void createNewManagerAppTest(){
        when(managerAppDAO.createManagerApp(mockManagerApp)).thenReturn(mockManagerApp);

        ManagerApp managerApp1 = managerService.createNewApp(mockManagerApp);

        Assertions.assertNotNull(managerApp1);
    }
    @Test
    public void getAppByIdTest(){
        when(managerService.getAppById(mockApplication.getAppId())).thenReturn(mockApplication);

        Application application = managerService.getAppById(mockApplication.getAppId());

        Assertions.assertNotNull(application);
    }
    @Test
    public void updateCurrentApp(){

    }





}
