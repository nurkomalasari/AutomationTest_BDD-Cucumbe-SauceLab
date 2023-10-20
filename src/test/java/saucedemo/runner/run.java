package saucedemo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/features/", // Specify the path to your feature files
        glue = "saucedemo.stepdefinitions", // Specify the package where your step definitions are
        plugin = {
                "pretty",
                "html:target/saucedemo-reports/outputReport.html", // HTML report
                "json:target/saucedemo-reports/outputReport.json", // JSON report
                "junit:target/saucedemo-reports/cucumber.xml", // JUnit XML report
                "usage:target/saucedemo-reports/usage.json" // Usage report in JSON format
        }
)

public class run {
}
