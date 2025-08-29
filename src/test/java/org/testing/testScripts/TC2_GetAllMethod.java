package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.responseValidation.ValidateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingOrgJson;
import org.testing.utilities.PropertiesHandle;
import org.testing.utilities.ReportHandling;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class TC2_GetAllMethod {
	
	@Test
	public void testCase2() throws IOException {
		
		
		ExtentReports report=ReportHandling.report();
		ExtentTest tc2= report.startTest("TC2_GetAllMethod");
		Properties pr=	 PropertiesHandle.LoadProerties("../API_Framework/URI.properties");
		
		
		
        HTTPMethods http =new HTTPMethods(pr);
        
        Response res =  http.getAllMethod("QA_URI1");
        
		Boolean result=	ValidateResponse.statusCodeValidate(200, res);
		Boolean dataresult=ValidateResponse.DataValidate("Shahid", res);
		 
		if((result==true)&&(dataresult==true))
		{
		tc2.log(LogStatus.PASS, "Status code is matching and data is also matching");
		
		}
		else
		{
			tc2.log(LogStatus.FAIL, "Status code is not matching and data is not matching");
		}
		
		report.endTest(tc2);
		report.flush();
		
		
	}  

}
