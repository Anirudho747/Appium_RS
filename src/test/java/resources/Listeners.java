package resources;


import org.testng.ITestListener;
import org.testng.ITestResult;

import basics.Base;

public class Listeners implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result)
	{
		String s = result.getName();
		Base.getScreenshot(s);
	}
	
}
