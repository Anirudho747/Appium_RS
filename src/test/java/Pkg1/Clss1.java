package Pkg1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basics.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Clss1 extends Base{
	
//	public AppiumDriver<MobileElement> driver;

//	@BeforeTest
//	public void setUp () throws MalformedURLException
//	{
//		DesiredCapabilities dc = new DesiredCapabilities();
//		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
//		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
//		dc.setCapability("platformName", "Android");
//		dc.setCapability("platformVersion", "10");
//		dc.setCapability("appPackage", "com.cubii");
//		dc.setCapability("app", "/home/ani/Downloads/Cubii.apk");
//		URL url = new URL("http://127.0.0.1:4723/wd/hub");
//		
//		driver = new AppiumDriver<MobileElement>(url,dc);
//		
//		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
//	}
	
	@Test
	public void tt() 
	{	
		driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'editText')]").sendKeys("Brad@gmail.com");	
		driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'editText2')]").sendKeys("Brad@123");
		driver.findElementById("btn_login").click();
	}
	
//	@AfterTest
//	public void tearDown()
//	{
//		driver.quit();
//	}

}
