package br.com.rsinet.hub_tdd.testcase;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
import io.appium.java_client.android.AndroidDriver;

public class PesquisaPorTexto_TC {

	AndroidDriver<MobileElement> driver;
	ExtentTest test = ExtentReport.getTest();
	ExtentReports extent = ExtentReport.getExtent();

	@Before
	public void abrirApp() throws Exception {
		driver = AppManager.startApp();
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pesquisa");
	}

	@Test
	public void PesquisaPorTextoValida() throws Exception {
		test = extent.startTest("Pesquisa por texto válida");
		
		Home_Page.lnk_Lupa(driver).click();
		Home_Page.txtbx_Pesquisar(driver).sendKeys(Data.dadoPesquisaValida());
		Home_Page.lnk_Lupa(driver).click();
		
		Scroll.scrollAndClick(driver, Data.dadoMouseValido2());
		
		Assert.assertEquals(true, Produtos_Page.titulo_Produto(driver).getText().equals(Data.dadoMouseValido2()));
		
		String screenShotPath = GetScreenShot.capture(driver, "pesquisa_por_texto_valida");
		test.log(LogStatus.PASS, "Print abaixo: " + test.addScreenCapture(screenShotPath));
	}

	@Test
	public void PesquisaPorTextoInvalida() throws Exception {
		test = extent.startTest("Pesquisa por texto inválida");
		
		Home_Page.lnk_Lupa(driver).click();
		Home_Page.txtbx_Pesquisar(driver).sendKeys(Data.dadoPesquisaInvalida());
		Home_Page.lnk_Lupa(driver).click();
		
		Assert.assertEquals(true, Produtos_Page.txt_Invalido(driver).getText().contains("No results for"));
		
		test.log(LogStatus.PASS, "Nenhum produto encontrado");
		String screenShotPath = GetScreenShot.capture(driver, "pesquisa_por_texto_invalida");
		test.log(LogStatus.PASS, "Print abaixo: " + test.addScreenCapture(screenShotPath));
	}

	@After
	public void fecharApp() {
		AppManager.closeApp(driver);
	}

}
