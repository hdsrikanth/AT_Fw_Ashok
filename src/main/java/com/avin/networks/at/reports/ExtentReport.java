package com.avin.networks.at.reports;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.avin.networks.at.config.constants.GlobalConstants;
import com.avin.networks.at.config.enums.CategoryType;

public final class ExtentReport {

	private ExtentReport() { 	}

	private static ExtentReports extent;
	public static ExtentTest test;

	public static void initReports() throws Exception {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			
			ExtentSparkReporter spark = new ExtentSparkReporter(GlobalConstants.getInstance().getPassedreportspath())
					.viewConfigurer()
					.viewOrder()
					.as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY, ViewName.AUTHOR })
					.apply();
			
			ExtentSparkReporter failedSpark = new ExtentSparkReporter(GlobalConstants.getInstance().getFailedreportspath())
					.filter()
					.statusFilter()
					.as(new Status[] { Status.FAIL, Status.SKIP })
					.apply();
			
			failedSpark.config().setDocumentTitle("Failed test case report");

			final File CONF = new File(GlobalConstants.getInstance().getReportconfigfilepath());
			spark.loadXMLConfig(CONF);

			extent.attachReporter(spark, failedSpark);
		}
	}

	public static void flushReports() throws IOException {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		// Desktop.getDesktop().browse(new File("Report.html").toURI());
	}

	public static void createTest(String testcaseName) {
		ExtentManager.setExtentTest(extent.createTest(testcaseName));
	}

	public static void addAuthors(String[] authors) {
		for (String author : authors) {
			ExtentManager.getExtentTest().assignAuthor(author);
		}
	}

	public static void addCategories(CategoryType[] categories) {
		for (CategoryType category : categories) {
			
			ExtentManager.getExtentTest().assignCategory(category.toString());
		}
	}
}
