package dev.kuhaneck.steps;

import dev.kuhaneck.runner.TestRunnerClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmployeeLoginNegative {
    private ChromeDriver driver = TestRunnerClass.driver;




    @Given("the employee is on the homepage")
    public void the_employee_is_on_the_homepage() {

        driver.navigate().to("C:\\Users\\Nicholas\\training-repos\\Project1-nkuhaneck\\ProjectOne\\src\\main\\resources\\public\\index.html");
        String title = driver.getTitle();
        Assertions.assertEquals("Home", title);
        // Write code here that turns the phrase above into concrete actions

    }
    @When("the employee clicks on employee login")
    public void the_employee_clicks_on_employee_login() {
        WebElement employeeLoginButton = driver.findElement(By.id("employeePage"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(employeeLoginButton));

        employeeLoginButton.click();
    }
    @Then("the employee should be on the employee login page")
    public void the_employee_should_be_on_the_employee_login_page() {

        String title = driver.getTitle();

        Assertions.assertEquals("Employee Login", title);



    }
    @When("the employee types {string} into the username input")
    public void the_employee_types_into_the_username_input(String string) {
        WebElement userInput = driver.findElement(By.id("username"));

        userInput.sendKeys(string);

    }
    @When("the employee types {string} into the password input")
    public void the_employee_types_into_the_password_input(String string) {
        WebElement passInput = driver.findElement(By.id("password"));
        passInput.sendKeys(string);
    }
    @When("the employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        WebElement logInButton = driver.findElement(By.id("loginButton"));
        logInButton.click();

    }
    @Then("employee should not be logged in")
    public void employee_should_not_be_logged_in() {
        String title = driver.getTitle();;

        Assertions.assertEquals("Employee Login", title);

    }
}