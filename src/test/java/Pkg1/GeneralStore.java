package Pkg1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import basics.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GeneralStore extends Base{

	
	
	@Test(enabled=true)
	public void Login() throws MalformedURLException 
	{
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Cuba\"))").click();
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hi");
	    driver.hideKeyboard();
	  //  driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	}
	
	@Test(enabled=false)
	public void toastMsgCheck() 
	{	
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Cuba\"))").click();
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
	    driver.hideKeyboard();
	    driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	    String toastMessage=driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
	    System.out.println(toastMessage);
	    AssertJUnit.assertEquals(toastMessage, "Please enter your name");
	}

	@Test(enabled=true,dependsOnMethods="Login")
	public void scrollItems() throws InterruptedException
	{
		double tot=0;
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))");
		driver.findElementByXPath("//*[@text=\"Jordan 6 Rings\"]/following::*[@text=\"ADD TO CART\"][1]").click();
		String tot1 = driver.findElement(By.xpath("//*[@text=\"Jordan 6 Rings\"]/following::android.widget.TextView[1]")).getText();
		System.out.println(tot1);
		System.out.println(tot1.substring(1));
		tot=tot+Double.parseDouble(tot1.substring(1));
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike SFB Jungle\"))");
		driver.findElementByXPath("//*[@text=\"Nike SFB Jungle\"]/following::*[@text=\"ADD TO CART\"][1]").click();
		String tot2 = driver.findElement(By.xpath("//*[@text=\"Nike SFB Jungle\"]/following::android.widget.TextView[1]")).getText();
		System.out.println(tot2);
		System.out.println(tot2.substring(1));
		tot=tot+Double.parseDouble(tot2.substring(1));
		
		System.out.println(tot);
		Thread.sleep(16);
		
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		
		
		String totFinal = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		System.out.println(totFinal);
		System.out.println(totFinal.substring(1));
		double totC = Double.parseDouble(totFinal.substring(1));
		
		AssertJUnit.assertEquals(tot, totC);
	}
	
}
