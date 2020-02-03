package br.com.rsinet.hub_tdd.testcase;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.rsinet.hub_tdd.manager.AppManager;
import br.com.rsinet.hub_tdd.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.util.Scroll;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PesquisaPorTexto_TC {
	
	AndroidDriver<MobileElement> driver;
	
	@Before
	public void abrirApp() throws MalformedURLException {
		driver = AppManager.startApp();
	}
	
	@Test
	public void PesquisaPorTextoValida() {
		Home_Page.lnk_Lupa(driver).click();
		Home_Page.txtbx_Pesquisar(driver).sendKeys("HP");
		Home_Page.lnk_Lupa(driver).click();
		Scroll.scrollAndClick(driver, "HP Z4000 WIRELESS MOUSE");
	}
	
	@After
	public void fecharApp() {
		AppManager.closeApp(driver);
	}

}
