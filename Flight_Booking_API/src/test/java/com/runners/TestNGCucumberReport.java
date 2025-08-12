package com.runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utils.ExtentReportListener;

public class TestNGCucumberReport {

    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void startReport() {
        String path = System.getProperty("user.dir") + "/target/ExtentReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Flight Booking API Tests");
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Your Name");
    }


    @AfterClass
    public void endReport() {
        extent.flush();
    }

    // You can log in steps:
    public void logStep(String step, boolean status) {
        if (status) {
            extent.createTest(step).log(Status.PASS, "Step passed");
        } else {
            extent.createTest(step).log(Status.FAIL, "Step failed");
        }
    }
}
