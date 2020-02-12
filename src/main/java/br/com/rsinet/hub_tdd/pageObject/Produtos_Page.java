package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Produtos_Page {
	
	public static MobileElement txt_Invalido(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewNoProductsToShow");
	}

	public static MobileElement titulo_Produto(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewProductName");
	}
	
	public static MobileElement lnk_Filters(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/imageViewFilter");
	}

	public static MobileElement btn_Apply(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewApply");
	}
	
	public static MobileElement txt_Error(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewNoProductsToShow");
	}
	
}
