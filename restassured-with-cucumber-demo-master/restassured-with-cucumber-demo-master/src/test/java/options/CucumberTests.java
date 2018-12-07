package options;

import cucumber.api.CucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedTestNGRunner;

@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
		retryCount = 3,
		overviewReport = true,
		toPDF = true,
		outputFolder = "./reports/DATE(dd-MM-yyyy)",
		screenShotLocation = "./reports/DATE(dd-MM-yyyy)/screenshots")
@CucumberOptions(
		plugin = {"html:target/cucumber-html-report",
				"json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
				"usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"},
		glue = {"stepdefs"},
		features = {"src/test/features"})
public class CucumberTests extends ExtendedTestNGRunner {}
