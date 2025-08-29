package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responseValidation.ValidateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonHandle;
import org.testing.utilities.LogsCapture;
import org.testing.utilities.PropertiesHandle;
import org.testing.utilities.ReportHandling;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class TC1_PostMethod {

	
	@Test
	public void testCase1()  throws IOException {
		
		
		ExtentReports report=ReportHandling.report();
		ExtentTest tc1= report.startTest("TC1_PostMethod");
		
		
		Properties pr=	 PropertiesHandle.LoadProerties("../API_Framework/URI.properties");
		String requestBody =JsonHandle.readJson("../API_Framework/src/test/java/org/testing/resources/requestBody.json");
		
		
		HTTPMethods http = new HTTPMethods(pr);
		Response res =http.postmethod("QA_URI1", requestBody);
		Boolean result=	ValidateResponse.statusCodeValidate(201, res);

		LogsCapture.takeLog("TC1_PostMethod","status code is "+res.statusCode());
		if(result==true)
		{
		tc1.log(LogStatus.PASS, "Status code is matching");
		
		}
		else
		{
			tc1.log(LogStatus.FAIL, "Status code is matching");
		}
		
		report.endTest(tc1);
		report.flush();
	}
	
}
