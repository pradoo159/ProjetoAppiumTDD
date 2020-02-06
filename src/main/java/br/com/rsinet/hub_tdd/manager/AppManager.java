package br.com.rsinet.hub_tdd.manager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppManager {

	private static AndroidDriver<MobileElement> driver;
	private static Boolean primeiroTeste = true;

	public static AndroidDriver<MobileElement> startApp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9");
		caps.setCapability("deviceName", "Erms");
		caps.setCapability("udid", "emulator-5554");

		caps.setCapability("appPackage", "com.Advantage.aShopping");
		caps.setCapability("appActivity", "com.Advantage.aShopping.SplashActivity");

		caps.setCapability("noReset", true);
		if (!primeiroTeste) {
			caps.setCapability("webDriverAgentUrl", "http://localhost:8100");
		}

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void closeApp(AndroidDriver driver) {
		primeiroTeste = false;
		driver.closeApp();
	}
	
	public static void restartApp(AndroidDriver driver) {
		primeiroTeste = false;
		driver.resetApp();
	}

}
