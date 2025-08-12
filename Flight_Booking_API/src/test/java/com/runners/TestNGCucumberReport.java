package com.runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utils.ExtentReportListener;

public class TestNGCucumberReport {

    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void startReport() {
        extent = ExtentReportListener.getReportObject();
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
