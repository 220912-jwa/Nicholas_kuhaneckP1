package dev.kuhaneck.steps;


import dev.kuhaneck.runner.TestRunnerClass;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ManagerLoginPositive {

    private ChromeDriver driver = TestRunnerClass.driver;

    @Then("manager should be on the manager homepage")
    public void manager_should_be_on_the_manager_homepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        wait.until(ExpectedConditions.titleIs("Manager Home"));

        Assertions.assertEquals("Manager Home", driver.getTitle());

    }
}
