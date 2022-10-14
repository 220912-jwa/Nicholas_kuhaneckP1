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

public class FormSubmission {
    private ChromeDriver driver = TestRunnerClass.driver;
    @Given("the employee is on the employee homepage")
    public void the_employee_is_on_the_employee_homepage() {
        driver.navigate().to("C:\\Users\\Nicholas\\training-repos\\Project1-nkuhaneck\\ProjectOne\\src\\main\\resources\\public\\index.html");
        WebElement employeeLoginButton = driver.findElement(By.id("employeePage"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(employeeLoginButton));

        employeeLoginButton.click();
        WebElement userInput = driver.findElement(By.id("username"));

        userInput.sendKeys("spaceman");
        WebElement passInput = driver.findElement(By.id("password"));
        passInput.sendKeys("password");
        WebElement logInButton = driver.findElement(By.id("loginButton"));
        logInButton.click();


    }
    @When("the employee fills out a date")
    public void the_employee_fills_out_a_date() {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("subdate")));

        WebElement dateInput = driver.findElement(By.id("subdate"));
        dateInput.sendKeys("11/05/2022");

    }
    @When("the employee fills out the location input")
    public void the_employee_fills_out_the_location_input() {
        WebElement locationInput = driver.findElement(By.id("location"));
        locationInput.sendKeys("The local community college");

    }
    @When("the employee selects a course type")
    public void the_employee_selects_a_course_type() {
        WebElement courseTypeInput = driver.findElement(By.id("courseType"));

        courseTypeInput.sendKeys("Certification");

    }
    @When("the employee selects a course time")
    public void the_employee_selects_a_course_time() {

        WebElement timeInput = driver.findElement(By.id("courseType"));
        timeInput.sendKeys("14:00");

    }
    @When("the employee fills out the description input")
    public void the_employee_fills_out_the_description_input() {

        WebElement descriptInput = driver.findElement(By.id("description"));

        descriptInput.sendKeys("This is an example of what the description would be.");

    }
    @When("the employee fills out the cost input")
    public void the_employee_fills_out_the_cost_input() {

        WebElement costInput = driver.findElement(By.id("cost"));
        costInput.sendKeys("35");



    }
    @When("the employee fills out the work relation input")
    public void the_employee_fills_out_the_work_relation_input() {
        WebElement relationInput = driver.findElement(By.id("workRelation"));
        relationInput.sendKeys("Direct");

    }
    @When("the employee clicks submit")
    public void the_employee_clicks_submit() {
    WebElement submitButton = driver.findElement(By.id("submitform"));
    submitButton.click();

    }
    @Then("the employee should see the form added to the forms table")
    public void the_employee_should_see_the_form_added_to_the_forms_table() {
        String relation ="Direct";
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[last()]/td[last()]")));

        WebElement relationCell = driver.findElement(By.xpath("//tbody/tr[last()]/td[last()]"));
        Assertions.assertEquals(relation, relationCell.getText());
    }


}
