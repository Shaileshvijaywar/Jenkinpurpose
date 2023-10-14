package com.genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersImplementation implements ITestListener{

	//@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"excution started");
		
	}

	//@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"TestPassed");
		
	}

	//@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"Test Failed");
		
	}

	//@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"Test Skipped");
		
	}

	//@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite execution started");
		
	}

	//@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite execution finished");
		
	}

}
