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

public class TC5_DeleteMethod {
	
	@Test
	public void testcase5() throws IOException {
		
		
		ExtentReports report=ReportHandling.report();
		ExtentTest tc5= report.startTest("TC5_DeleteMethod");
		Properties pr=	 PropertiesHandle.LoadProerties("../API_Framework/URI.properties");
        HTTPMethods http =new HTTPMethods(pr);
        Response res=   http.deleteMethod("QA_URI1","11");
        Boolean result =ValidateResponse.statusCodeValidate(200, res);
        
        if(result==true)
		{
		tc5.log(LogStatus.PASS, "Status code is matching");
		
		}
		else
		{
			tc5.log(LogStatus.FAIL, "Status code is matching");
		}
		
		report.endTest(tc5);
		report.flush();
		
        
        //That’s why:

//Works in Postman → because you probably selected the numeric id record (or JSON Server resolved it differently).

//Doesn’t work in Rest Assured → because Rest Assured just concatenates "DC1" onto the URI, and JSON Server doesn’t match it as a resource.
	}
	
	
	

}
