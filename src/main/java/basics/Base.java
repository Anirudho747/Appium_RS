package basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	
public static AndroidDriver<MobileElement> driver;
public static AppiumDriverLocalService service;

public static boolean checkIfServerIsRunnning(int port) {
	
	boolean isServerRunning = false;
	ServerSocket serverSocket;
	try {
		serverSocket = new ServerSocket(port);
		
		serverSocket.close();
	} catch (IOException e) {
		//If control comes here, then it means that the port is in use
		isServerRunning = true;
	} finally {
		serverSocket = null;
	}
	return isServerRunning;
}

public static void startEmulator()
{
	String src =System.getProperty("user.dir")+ "/src/main/resources/Utilities/startEmulator.bat";
	try {
		Runtime.getRuntime().exec(src);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	@BeforeTest
	public void setUp() throws IOException {

		Runtime.getRuntime().exec("killall -KILL myStupidProcess");
		boolean flag=	checkIfServerIsRunnning(4723);
		if(!flag)
		{
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String applocation = System.getProperty("user.dir")+"/src/main/resources/App";
		
		File appDir = new File(applocation);
		File app    = new File(appDir,(String) prop.get("AppName"));
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, prop.get("Device"));
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10");
		dc.setCapability(MobileCapabilityType.APP,"appname");
		dc.setCapability("appPackage", "com.androidsample.generalstore");
		dc.setCapability("app", "/home/ani/Downloads/General_Store.apk");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url,dc);
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
	}
	
	public static void getScreenshot(String name)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		String destPath = System.getProperty("user.dir")+"/test-output/Snap/error"+name+".png";
		File scrfile = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrfile, new File(destPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		service.stop();
	
	}

}
