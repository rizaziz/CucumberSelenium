package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"/Users/admin/Desktop/CucumberSelenium/SalaryCalc/src/test/features/Smoke.feature"},
                 glue = {"cucumber/stepdef"},
                 format={"pretty"})
public class TestRunnerWithTestNG extends AbstractTestNGCucumberTests {

}
