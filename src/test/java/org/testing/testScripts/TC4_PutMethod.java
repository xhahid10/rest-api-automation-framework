package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responseValidation.ValidateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonHandle;
import org.testing.utilities.PropertiesHandle;
import org.testing.utilities.ReportHandling;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class TC4_PutMethod {

	
	@Test
	public void testCase4() throws IOException {
		
		
		ExtentReports report=ReportHandling.report();
		ExtentTest tc4= report.startTest("TC4_PutMethod");
		Properties pr=	 PropertiesHandle.LoadProerties("../API_Framework/URI.properties");
		String requestBody =JsonHandle.readJson("../API_Framework/src/test/java/org/testing/resources/updateRequestBody.json");
		
		
		HTTPMethods http = new HTTPMethods(pr);
		Response res= http .putmethod("QA_URI1","22", requestBody);
		Boolean result=ValidateResponse.statusCodeValidate(201, res);
		  if(result==true)
			{
			tc4.log(LogStatus.PASS, "Status code is matching");
			
			}
			else
			{
				tc4.log(LogStatus.FAIL, "Status code is matching");
			}
			
			report.endTest(tc4);
			report.flush();
		
		
		
		
	}
}
