package dev.kuhaneck.steps;

import dev.kuhaneck.runner.TestRunnerClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagerLoginNegative {
    private ChromeDriver driver = TestRunnerClass.driver;


    @Given("the manager is on the homepage")
    public void the_manager_is_on_the_homepage() {
        driver.navigate().to("C:\\Users\\Nicholas\\training-repos\\Project1-nkuhaneck\\ProjectOne\\src\\main\\resources\\public\\index.html");
        String title = driver.getTitle();
        Assertions.assertEquals("Home", title);

    }

    @When("the manager clicks on manager login")
    public void the_manager_clicks_on_manager_login() {
        WebElement button = driver.findElement(By.id("managerPage"));

        button.click();
    }

    @Then("the manager should be on the manager login page")
    public void the_manager_should_be_on_the_manager_login_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.titleIs("Manager Login"));
        String title = driver.getTitle();
        Assertions.assertEquals("Manager Login", title);

    }

    @When("the manager types {string} into the username input")
    public void the_manager_types_into_the_username_input(String string) {

        WebElement userInput = driver.findElement(By.id("username"));
        userInput.sendKeys(string);


    }

    @When("the manager types {string} into the password input")
    public void the_manager_types_into_the_password_input(String string) {
        WebElement passInput = driver.findElement(By.id("password"));
        passInput.sendKeys(string);
    }

    @When("the manager clicks on the login button")
    public void the_manager_clicks_on_the_login_button() {
       WebElement loginButton = driver.findElement(By.id("loginButton"));
       loginButton.click();
    }

    @Then("manager should not be logged in")
    public void manager_should_not_be_logged_in() {
        String title = driver.getTitle();
        Assertions.assertEquals("Manager Login", title);
    }


}