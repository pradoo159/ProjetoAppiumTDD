package br.com.rsinet.hub_tdd.pageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Home_Page {

	public static MobileElement btn_Menu(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/imageViewMenu");
	}

	public static MobileElement lnk_Login(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewMenuUser");
	}

	public static MobileElement lnk_Cadastrar(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/textViewSingUpToday");
	}
	
	public static MobileElement lnk_Lupa(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/imageViewSearch");
	}
	
	public static MobileElement txtbx_Pesquisar(AndroidDriver<?> driver) {
		return (MobileElement) driver.findElementById("com.Advantage.aShopping:id/editTextSearch");
	}
}
