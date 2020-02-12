package br.com.rsinet.hub_tdd.testcase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.rsinet.hub_tdd.actions.NumericalKeyboard;
import br.com.rsinet.hub_tdd.manager.AppManager;
import br.com.rsinet.hub_tdd.pageObject.Cadastro_Page;
import br.com.rsinet.hub_tdd.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.util.Constant;
import br.com.rsinet.hub_tdd.util.Data;
import br.com.rsinet.hub_tdd.util.ExcelUtils;
import br.com.rsinet.hub_tdd.util.ExtentReport;
import br.com.rsinet.hub_tdd.util.GetScreenShot;
import br.com.rsinet.hub_tdd.util.Scroll;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;

public class Cadastro_TC {

	private AndroidDriver<MobileElement> driver;
	private TouchAction<?> action;
	ExtentTest test = ExtentReport.getTest();
	ExtentReports extent = ExtentReport.getExtent();


	@Before
	public void iniciarApp() throws Exception {
		driver = AppManager.startApp();
	}

	@Test
	public void DeveCadastrarUmUsuario() throws Exception {
		String usuario = "prado09";
		test = extent.startTest("Cadastro válido");
		action = new TouchAction(driver);
		Home_Page.btn_Menu(driver).click();
		Home_Page.lnk_Login(driver).click();
		Home_Page.lnk_Cadastrar(driver).click();
		Cadastro_Page.txtbx_Username(driver).click();
		Cadastro_Page.txtbx_Username(driver).sendKeys(usuario);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_Email(driver).sendKeys("emerson.prado@rsinet.com.br");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_Password(driver).sendKeys("Teste@1234");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_ConfirmPassword(driver).sendKeys("Teste@1234");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_LastName(driver).sendKeys("Prado");
		Cadastro_Page.txtbx_FirstName(driver).click();
		Cadastro_Page.txtbx_FirstName(driver).sendKeys("Emerson");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		NumericalKeyboard.PreencherPhoneNumber(driver);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_State(driver).click();
		Cadastro_Page.txtbx_State(driver).sendKeys("Sao Paulo");
		Cadastro_Page.txtbx_Country(driver).click();
		Scroll.scrollAndClick(driver, "Brazil");
		Cadastro_Page.txtbx_State(driver).click();
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_Address(driver).click();
		Cadastro_Page.txtbx_Address(driver).sendKeys("Avenida dos remedios");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_Cep(driver).sendKeys("06283119");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Cadastro_Page.txtbx_City(driver).click();
		Cadastro_Page.txtbx_City(driver).sendKeys("Osasco");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Scroll.onlyScroll(driver, "REGISTER");
		Scroll.swipe(523, 1400, 523, 1300, driver);
		Cadastro_Page.btn_Register(driver).click();
		action.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000))).perform();
		Home_Page.btn_Menu(driver).click();
		action.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000))).perform();
		assertTrue(Home_Page.lnk_Login(driver).getText().contains(usuario));
		String screenShotPath = GetScreenShot.capture(driver, "cadastro_valido");
		test.log(LogStatus.PASS, "teste finalizado, print abaixo: " +  test.addScreenCapture(screenShotPath));
		

	}

	@Test
	public void NaoDeveCadastrarUmUsuarioComEmailInvalido() throws Exception {

		action = new TouchAction(driver);
		test = extent.startTest("Cadastro Inválido");
		Home_Page.btn_Menu(driver).click();
		Home_Page.lnk_Login(driver).click();
		Home_Page.lnk_Cadastrar(driver).click();
		Cadastro_Page.txtbx_Username(driver).click();
		Cadastro_Page.txtbx_Username(driver).sendKeys("pradov1025");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_Email(driver).sendKeys("emerson.pradorsinet.com3.br");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		test.log(LogStatus.INFO, "Inserindo email inválido");
		String screenShotPath = GetScreenShot.capture(driver, "cadastro_com_email_invalido");
		Cadastro_Page.txtbx_Password(driver).sendKeys("Teste@1234");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_ConfirmPassword(driver).sendKeys("Teste@1234");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_LastName(driver).sendKeys("Prado");
		Cadastro_Page.txtbx_FirstName(driver).click();
		Cadastro_Page.txtbx_FirstName(driver).sendKeys("Emerson");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		NumericalKeyboard.PreencherPhoneNumber(driver);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_State(driver).click();
		Cadastro_Page.txtbx_State(driver).sendKeys("São Paulo");
		Cadastro_Page.txtbx_Country(driver).click();
		Scroll.scrollAndClick(driver, "Brazil");
		Cadastro_Page.txtbx_State(driver).click();
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_Address(driver).click();
		Cadastro_Page.txtbx_Address(driver).sendKeys("Avenida dos remédios");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_Cep(driver).sendKeys("06293110");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Cadastro_Page.txtbx_City(driver).click();
		Cadastro_Page.txtbx_City(driver).sendKeys("Osasco");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Scroll.onlyScroll(driver, "REGISTER");
		Scroll.swipe(523, 1400, 523, 1300, driver);
		Cadastro_Page.btn_Register(driver).click();
		assertFalse(Cadastro_Page.btn_Register(driver).isEnabled());
		action.waitAction(new WaitOptions().withDuration(Duration.ofMillis(4000))).perform();
		test.log(LogStatus.PASS, "fim do teste");
		test.log(LogStatus.PASS, "Print abaixo: " + test.addScreenCapture(screenShotPath));

	}

	@After
	public void fecharApp() {
		AppManager.closeApp(driver);
	}
	
}
