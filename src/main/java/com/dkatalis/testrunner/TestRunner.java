package com.dkatalis.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features="src/test/java/com/dkatalis/DkatalisAssignment/features",plugin="json:target/jsonReports/cucumber_report.json",glue= {"com/dkatalis/stepdefinition"})
public class TestRunner extends AbstractTestNGCucumberTests{
//  private TestNGCucumberRunner testNGCucumberRunner;
//  
//  @BeforeClass(alwaysRun = true)
//  public void setUpClass() throws Exception {
//      testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//  }
}