package dev.kuhaneck.unittest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import dev.kuhaneck.DAOS.EmployeeDAO;
import dev.kuhaneck.DAOS.ManagerDAO;
import dev.kuhaneck.entities.Employee;
import dev.kuhaneck.services.LoginService;

import io.cucumber.java.an.E;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ServiceLayerUnitTest {

    @InjectMocks
    private static LoginService loginService;

    @Mock
    private static EmployeeDAO employeeDAO;
    private static ManagerDAO managerDAO;
    private Employee mockEmployeeWithGoodCreds;
    private Employee mockEmployeeWithBadCreds


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
        mockEmployeeWithBadCreds =  new Employee(
                3,
                "Busman",
                "Smalls",
                "badName",
                "badPass",
                1000
        );
    }



}
