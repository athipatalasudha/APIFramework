package api.test.runner;
import org.testng.annotations.AfterTest;
import api.test.stepdefinitions.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports/cucumber.html",
"json:target/cucumber-reports/cucumber.json" }, 
features = {"src/test/java/api/test/features/crud.feature" }, 
glue = { "api.test.stepdefinitions" })

public class Runner extends AbstractTestNGCucumberTests {

}