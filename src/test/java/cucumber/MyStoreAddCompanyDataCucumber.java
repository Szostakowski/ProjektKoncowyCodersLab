package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features/", plugin = {"pretty","html:out"})

public class MyStoreAddCompanyDataCucumber {
}
