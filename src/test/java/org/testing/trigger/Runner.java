package org.testing.trigger;

import java.io.IOException;

import org.testing.testScripts.TC1_PostMethod;
import org.testing.testScripts.TC2_GetAllMethod;
import org.testing.testScripts.TC3_getParticularMethod;
import org.testing.testScripts.TC4_PutMethod;
import org.testing.testScripts.TC5_DeleteMethod;

public class Runner {
	
	public static void main(String[] args) throws IOException {
		
		
		
		TC1_PostMethod tc1=new TC1_PostMethod();
		tc1.testCase1();
		
		TC2_GetAllMethod tc2= new TC2_GetAllMethod();
		tc2.testCase2();
		
		TC3_getParticularMethod tc3 =new TC3_getParticularMethod();
		tc3.testcase3();
		
		TC4_PutMethod tc4= new TC4_PutMethod();
		tc4.testCase4();
		
		TC5_DeleteMethod tc5=new TC5_DeleteMethod();
		tc5.testcase5();
		
	}

}
