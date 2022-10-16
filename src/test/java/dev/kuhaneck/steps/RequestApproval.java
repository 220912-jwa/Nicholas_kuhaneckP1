package dev.kuhaneck.steps;

import dev.kuhaneck.runner.TestRunnerClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RequestApproval {

    private ChromeDriver driver = TestRunnerClass.driver;
    @When("the manager clicks Approve Reimbursement")
    public void the_manager_clicks_approve_reimbursement() {

        WebElement button = driver.findElement(By.id("approve"));
        button.click();

    }
    @Then("the manager should see an alert that the request was approved")
    public void the_manager_should_see_an_alert_that_the_request_was_approved() {

        Assertions.assertTrue(ExpectedConditions.alertIsPresent()!= null);

    }
    @When("the manager clicks deny")
    public void the_manager_clicks_deny() {
        WebElement button = driver.findElement(By.id("deny"));
        button.click();
    }
    @Then("the manager should see an alert that the request was denied")
    public void the_manager_should_see_an_alert_that_the_request_was_denied() {
        Assertions.assertTrue(ExpectedConditions.alertIsPresent()!= null);
    }
}
