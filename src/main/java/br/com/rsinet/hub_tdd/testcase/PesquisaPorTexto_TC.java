package br.com.rsinet.hub_tdd.testcase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.rsinet.hub_tdd.manager.AppManager;
import br.com.rsinet.hub_tdd.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.pageObject.Produtos_Page;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.Data;
import br.com.rsinet.hub_tdd.util.ExcelUtils;
import br.com.rsinet.hub_tdd.util.ExtentReport;
import br.com.rsinet.hub_tdd.util.GetScreenShot;
import br.com.rsinet.hub_tdd.util.Scroll;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class PesquisaPorTexto_TC {

	private AndroidDriver<MobileElement> driver;
	ExtentTest test = ExtentReport.getTest();
	ExtentReports extent = ExtentReport.getExtent();

	@Before
	public void iniciarApp() throws Exception {
		driver = AppManager.startApp();
	}

	@Test
	public void PesquisaPorTextoValida() throws Exception {
		test = extent.startTest("Pesquisa por texto válida");
		
		Home_Page.lnk_Lupa(driver).click();
		Home_Page.txtbx_Pesquisar(driver).sendKeys("MOUSE");
		Home_Page.lnk_Lupa(driver).click();
		
		Scroll.scrollAndClick(driver, "HP Z8000 BLUETOOTH MOUSE");
		
		Assert.assertEquals(true, Produtos_Page.titulo_Produto(driver).getText().contains("HP Z8000 BLUETOOTH MOUSE"));
		
		String screenShotPath = GetScreenShot.capture(driver, "pesquisa_por_texto_valida");
		test.log(LogStatus.PASS, "Print abaixo: " + test.addScreenCapture(screenShotPath));
	}

	@Test
	public void PesquisaPorTextoInvalida() throws Exception {
		test = extent.startTest("Pesquisa por texto inválida");
		
		Home_Page.lnk_Lupa(driver).click();
		Home_Page.txtbx_Pesquisar(driver).sendKeys("Celular");
		Home_Page.lnk_Lupa(driver).click();
		
		Assert.assertEquals(true, Produtos_Page.txt_Invalido(driver).getText().contains("No results for"));
		
		String screenShotPath = GetScreenShot.capture(driver, "pesquisa_por_texto_invalida");
		test.log(LogStatus.PASS, "Print abaixo: " + test.addScreenCapture(screenShotPath));
	}

	@After
	public void fecharApp() {
		AppManager.closeApp(driver);
	}

}
