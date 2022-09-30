package stepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	    features = {"Feature Files"},
		glue={"stepDefinitions"},
		//dryRun=true,

		plugin = { "de.monochromata.cucumber.report.PrettyReports:target/cucumber", 
				   "json:target/cucumber.json" },
		tags= "@Sanity"
	    

		)
 
public class TestRunner extends AbstractTestNGCucumberTests
{
	
 
}

