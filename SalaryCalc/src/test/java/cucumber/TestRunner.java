package cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"/Users/admin/Desktop/CucumberSelenium/SalaryCalc/src/test/features/Smoke.feature"},
        glue = {"cucumber/stepdef"})
public class TestRunner {
}
