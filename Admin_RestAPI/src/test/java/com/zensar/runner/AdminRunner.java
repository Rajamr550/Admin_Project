package com.zensar.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/seleniumTest.feature",
		glue = "com.zensar",
		publish = true
		
		)
public class AdminRunner {
	

}
