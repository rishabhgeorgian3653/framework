package com.qa.testcases;

    import org.testng.ITestListener;

import java.io.IOException;

import org.testng.ITestContext ;		
	import org.testng.ITestResult ;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.base.TestBase;
import com.qa.util.ExtentReporterNG;		

	public class ListenerTest extends TestBase implements ITestListener						
	{		
        public ListenerTest() throws IOException {
			super();
			// TODO Auto-generated constructor stub
		}

		ExtentReports extent = ExtentReporterNG.getReportObject();
        ExtentTest test;
	    @Override		
	    public void onFinish(ITestContext result) {					
	        // TODO Auto-generated method stub				
	        		extent.flush();
	    }		

	    @Override		
	    public void onStart(ITestContext result) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestFailure(ITestResult result) {					
	        // TODO Auto-generated method stub				
	    	    test.fail(result.getThrowable());
	    	    String filepath = null;
				try {
					filepath = getScreenshots(result.getMethod().getMethodName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
	    }		

	    @Override		
	    public void onTestSkipped(ITestResult result) {					
	        // TODO Auto-generated method stub	
	    	 test.log(Status.SKIP, "test Skipped");
	        		
	    }		

	    @Override		
	    public void onTestStart(ITestResult result) {					
	        // TODO Auto-generated method stub	
	    	test = extent.createTest(result.getMethod().getMethodName());
	        		
	    }		

	    @Override		
	    public void onTestSuccess(ITestResult result) {					
	        // TODO Auto-generated method stub				
	        test.log(Status.PASS, "test Passed");
	    }		
	}		


