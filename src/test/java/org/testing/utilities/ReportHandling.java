package org.testing.utilities;



import com.relevantcodes.extentreports.ExtentReports;

public class ReportHandling {
	
	public static ExtentReports report() {
	
     	ExtentReports report= new ExtentReports("C:\\Users\\chins\\Desktop\\Reports\\report.html",false); //true and false is to override or append the test cases
     	return report;
     	
     	
     	
	
	}
}
