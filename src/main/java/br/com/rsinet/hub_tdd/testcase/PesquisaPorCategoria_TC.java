package br.com.rsinet.hub_tdd.testcase;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import br.com.rsinet.hub_tdd.manager.AppManager;
import br.com.rsinet.hub_tdd.util.Scroll;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PesquisaPorCategoria_TC {

	AndroidDriver<MobileElement> driver;
	
	@Before
	public void abrirApp() throws MalformedURLException {
		driver = AppManager.startApp();
	}
	
	@Test
	public void DeveProcurarUmProdutoPelaCategoria() {
		Scroll.scrollAndClick(driver, "MICE");
		Scroll.scrollAndClick(driver, "MICROSOFT SCULPT TOUCH MOUSE");
	}
	
}
