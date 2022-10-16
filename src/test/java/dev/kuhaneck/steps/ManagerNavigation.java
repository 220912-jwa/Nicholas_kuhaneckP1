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


public class ManagerNavigation {

    private ChromeDriver driver = TestRunnerClass.driver;

    @When("the manager clicks on the edit button")
    public void the_manager_clicks_on_the_edit_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("/html/body/div[1]/table/tbody/tr/td[16]/button"))));
       WebElement button = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr/td[16]/button"));
       button.click();
    }
    @Then("the manager should be on the page titled {string}")
    public void the_manager_should_be_on_the_page_titled(String string) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.titleIs("Approval Page"));
        String title = driver.getTitle();
        Assertions.assertEquals(string, title);

    }
}