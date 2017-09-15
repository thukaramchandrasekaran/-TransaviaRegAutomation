package trans.java.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/trans/resources" }, plugin = { "pretty",
		"html:results/html" }, tags = { "@Priority1" }, glue = { "trans.java.glue" })

public class RunnerClass {

}
