package br.com.rsinet.hub_tdd.testcase;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.rsinet.hub_tdd.manager.AppManager;
import br.com.rsinet.hub_tdd.pageObject.Produtos_Page;
import br.com.rsinet.hub_tdd.util.Click;
import br.com.rsinet.hub_tdd.util.ExtentReport;
import br.com.rsinet.hub_tdd.util.GetScreenShot;
import br.com.rsinet.hub_tdd.util.Scroll;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;

public class PesquisaPorCategoria_TC {

	private AndroidDriver<MobileElement> driver;
	ExtentTest test = ExtentReport.getTest();
	ExtentReports extent = ExtentReport.getExtent();
	
	@Before
	public void abrirApp() throws MalformedURLException {
		driver = AppManager.startApp();
	}
	
	@Test
	public void DeveProcurarUmProdutoPelaCategoria() throws IOException {
		test = extent.startTest("Pesquisa por categoria válida");
		String produto = "MICROSOFT SCULPT TOUCH MOUSE";
		Scroll.scrollAndClick(driver, "MICE");
		Scroll.scrollAndClick(driver, produto);
		assertTrue(Produtos_Page.titulo_Produto(driver).getText().contains(produto));
		test.log(LogStatus.PASS, "Teste Passou");
		String screenShotPath = GetScreenShot.capture(driver, "pesquisa_por_categoria_valida");
		test.log(LogStatus.PASS, "Print abaixo: " + test.addScreenCapture(screenShotPath));
	}
	
	@Test
	public void DeveFiltrarENaoEncontrarNenhumProduto() throws IOException {
		test = extent.startTest("Pesquisa por categoria inválida");
		Scroll.scrollAndClick(driver, "HEADPHONES");
		TouchAction action = new TouchAction(driver);
		action.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000))).perform();
		Produtos_Page.lnk_Filters(driver).click();
		Click.ByVisibleText(driver, "BY COMPATIBILITY");
		Click.ByVisibleText(driver, "Smart phone compatibility");
		Click.ByVisibleText(driver, "BY COMPATIBILITY");
		Click.ByVisibleText(driver, "BY CONNECTOR");
		Click.ByVisibleText(driver, "BlueTooth");
		Click.ByVisibleText(driver, "BY CONNECTOR");
		Produtos_Page.btn_Apply(driver).click();
		assertTrue(Produtos_Page.txt_Error(driver).getText().contains("No results"));
		test.log(LogStatus.PASS, "Teste Passou");
		String screenShotPath = GetScreenShot.capture(driver, "pesquisa_por_categoria_invalida");
		test.log(LogStatus.PASS, "Print abaixo: " + test.addScreenCapture(screenShotPath));
	}
	

	@After
	public void fecharApp() {
		AppManager.closeApp(driver);
	}
	
}
