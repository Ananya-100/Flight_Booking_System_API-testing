package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.steps"},
    plugin = {
        "pretty",
        "html:target/cucumber.html",
        "json:target/cucumber.json"
    },
    monochrome = true
)
public class TestRunners extends AbstractTestNGCucumberTests { }
