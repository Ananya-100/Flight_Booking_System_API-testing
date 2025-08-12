package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener {

    private static ExtentReports extent;

    public static ExtentReports getReportObject() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "/target/ExtentReport.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("Flight Booking API Tests");
            reporter.config().setDocumentTitle("API Automation Report");
            reporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Your Name");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}
