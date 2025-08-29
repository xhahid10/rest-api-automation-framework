package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responseValidation.ValidateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.PropertiesHandle;
import org.testing.utilities.ReportHandling;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class TC3_getParticularMethod {
	
	@Test
	public void testcase3() throws IOException {
		
		ExtentReports report=ReportHandling.report();
		ExtentTest tc3= report.startTest("TC3_getParticularMethod");
		
		Properties pr=	 PropertiesHandle.LoadProerties("../API_Framework/URI.properties");
        HTTPMethods http =new HTTPMethods(pr);
        Response res=   http.getParticularMethod("QA_URI1","aman22");
        Boolean result=  ValidateResponse.statusCodeValidate(200, res);
        if(result==true)
		{
		tc3.log(LogStatus.PASS, "Status code is matching");
		
		}
		else
		{
			tc3.log(LogStatus.FAIL, "Status code is matching");
		}
		
		report.endTest(tc3);
		report.flush();
		
	}
	
	
	

}
