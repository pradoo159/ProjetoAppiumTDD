package br.com.rsinet.hub_tdd.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class Screenshot {

	public static void TirarPrint(AndroidDriver driver, String nomePrint) {
		
		String local = "C:\\Users\\emerson.prado\\eclipse-toolsqa\\workspace-appium\\AOS_Appium_TDD\\screenshot\\" 
		+ nomePrint + ".png";
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(local));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
