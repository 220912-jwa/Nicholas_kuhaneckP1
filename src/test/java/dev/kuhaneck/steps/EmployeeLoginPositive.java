package dev.kuhaneck.steps;

import dev.kuhaneck.runner.TestRunnerClass;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmployeeLoginPositive {

    private ChromeDriver driver = TestRunnerClass.driver;
    @Then("employee should be on the employee homepage")
    public void employee_should_be_on_the_employee_homepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        wait.until(ExpectedConditions.titleIs("ERS Form"));

        String title = driver.getTitle();

        Assertions.assertEquals("ERS Form", title);

    }


}
