package br.com.rsinet.hub_tdd.manager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppManager {

	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> startApp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "Erms");
		caps.setCapability("newCommandTimeout", "60");
		caps.setCapability("appPackage", "com.Advantage.aShopping");
		caps.setCapability("appActivity", "com.Advantage.aShopping.SplashActivity");

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void closeApp(AndroidDriver driver) {
		driver.quit();
	}
	
}
