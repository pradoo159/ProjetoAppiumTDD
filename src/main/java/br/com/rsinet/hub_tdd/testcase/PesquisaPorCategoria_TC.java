package br.com.rsinet.hub_tdd.testcase;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.rsinet.hub_tdd.manager.AppManager;
import br.com.rsinet.hub_tdd.util.ExtentReport;
import br.com.rsinet.hub_tdd.util.GetScreenShot;
import br.com.rsinet.hub_tdd.util.Scroll;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PesquisaPorCategoria_TC {

	AndroidDriver<MobileElement> driver;
	ExtentTest test = ExtentReport.getTest();
	ExtentReports extent = ExtentReport.getExtent();
	
	@Before
	public void abrirApp() throws MalformedURLException {
		driver = AppManager.startApp();
	}
	
	@Test
	public void DeveProcurarUmProdutoPelaCategoria() throws IOException {
		test = extent.startTest("Pesquisa por categoria válida");
		Scroll.scrollAndClick(driver, "MICE");
		Scroll.scrollAndClick(driver, "MICROSOFT SCULPT TOUCH MOUSE");
		test.log(LogStatus.PASS, "Teste Passou");
		String screenShotPath = GetScreenShot.capture(driver, "pesquisa_por_categoria_valida");
		test.log(LogStatus.PASS, "Print abaixo: " + test.addScreenCapture(screenShotPath));
	}
	
	@After
	public void fecharApp() {
		AppManager.closeApp(driver);
	}
	
}
