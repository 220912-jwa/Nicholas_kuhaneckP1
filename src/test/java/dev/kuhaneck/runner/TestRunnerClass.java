package dev.kuhaneck.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/dev/kuhaneck/features", glue = "dev.kuhaneck.steps")

public class TestRunnerClass {


    public static ChromeDriver driver;

    @BeforeClass
        public static void setUp(){
            System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();

    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }


}
