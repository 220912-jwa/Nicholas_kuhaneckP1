package dev.kuhaneck.steps;

import dev.kuhaneck.runner.TestRunnerClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagerFormSubmission {

    private ChromeDriver driver = TestRunnerClass.driver;

    @When("the manager clicks on Submit a new request")
    public void the_manager_clicks_on_submit_a_new_request() {
       WebElement button = driver.findElement(By.linkText("Submit a new request"));
       button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.titleIs("Manager Form Submission"));

    }
    @When("the manager enters a Submission date")
    public void the_manager_enters_a_submission_date() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("subdate")));

        WebElement dateInput = driver.findElement(By.id("subdate"));
        dateInput.sendKeys("11/05/2022");

    }
    @When("the manager enters a course location")
    public void the_manager_enters_a_course_location() {
        WebElement locationInput = driver.findElement(By.id("location"));
        locationInput.sendKeys("The local community college");

    }
    @When("the manager selects a course type")
    public void the_manager_selects_a_course_type() {
        WebElement courseTypeInput = driver.findElement(By.id("courseType"));

        courseTypeInput.sendKeys("Certification");

    }
    @When("the manager selects a course time")
    public void the_manager_selects_a_course_time() {
        WebElement timeInput = driver.findElement(By.id("courseTime"));
        timeInput.sendKeys("1400");


    }
    @When("the manager enters a course description")
    public void the_manager_enters_a_course_description() {
        WebElement descriptInput = driver.findElement(By.id("description"));

        descriptInput.sendKeys("This is an example of what the description would be.");


    }
    @When("the manager enters a course cost")
    public void the_manager_enters_a_course_cost() {
        WebElement costInput = driver.findElement(By.id("cost"));
        costInput.sendKeys("35");



    }
    @When("the manager enters a work relation")
    public void the_manager_enters_a_work_relation() {
        WebElement relationInput = driver.findElement(By.id("workRelation"));
        relationInput.sendKeys("Direct");
    }
    @When("the manager clicks the submit button")
    public void the_manager_clicks_the_submit_button() {
        WebElement submitButton = driver.findElement(By.id("submitform"));
        submitButton.click();

    }
    @Then("the manager should see an alert that the request was submitted")
    public void the_manager_should_see_an_alert_that_the_request_was_submitted() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
        wait.until(ExpectedConditions.alertIsPresent());
        Assertions.assertTrue(ExpectedConditions.alertIsPresent()!= null);
        driver.switchTo().alert().accept();

    }



}
