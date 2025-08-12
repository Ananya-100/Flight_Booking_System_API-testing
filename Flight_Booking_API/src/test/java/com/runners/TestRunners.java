package com.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.steps"},
    plugin = {
    		"pretty",
	        "html:target/cucumber.html"
	        
    		
    },
    monochrome = true
)
public class TestRunners { }
//this is updated to check push.