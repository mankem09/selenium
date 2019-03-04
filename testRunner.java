package Fly.Neon_DX.Helper;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/resources/features", glue = { ".classpath" },tags= {"@sanity"}, plugin = { "pretty",
		"html:target/cucumber-reports/cucumber-pretty", "json:target/cucumber-reports/CucumberTestReport.json",
		"rerun:target/cucumber-reports/rerun.txt" })
public class testRunner {
private TestNGCucumberRunner testNGCucumberRunner;
@BeforeClass(alwaysRun=true)
public void setupClass() {
	
	testNGCucumberRunner= new TestNGCucumberRunner(this.getClass());
}
@Test(groups="cucumber",description="Runs Cucumber Features",dataProvider="features")
public void Features(CucumberFeatureWrapper cucumberFeature) {
	testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
}
@DataProvider
public Object[][] features(){
	return testNGCucumberRunner.provideFeatures();
}
@AfterClass(alwaysRun=true)
public void closeBrowser() {
	testNGCucumberRunner.finish();
	
}
}
