package br.com.rsinet.hub_tdd.testcase;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
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

	private static AndroidDriver<MobileElement> driver;
	private TouchAction<?> action;
	ExtentTest test = ExtentReport.getTest();
	ExtentReports extent = ExtentReport.getExtent();


	@Before
	public static void iniciarApp() throws Exception {
		driver = AppManager.startApp();
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
	}

	@Test
	public void DeveCadastrarUmUsuario() throws Exception {
		test = extent.startTest("Cadastro válido");
		action = new TouchAction(driver);
		Home_Page.btn_Menu(driver).click();
		Home_Page.lnk_Login(driver).click();
		Home_Page.lnk_Cadastrar(driver).click();
		Cadastro_Page.txtbx_Username(driver).click();
		Cadastro_Page.txtbx_Username(driver).sendKeys(Data.usuarioCadastro());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_Email(driver).sendKeys(Data.emailCadastro());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_Password(driver).sendKeys(Data.senhaCadastro());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_ConfirmPassword(driver).sendKeys(Data.senhaCadastro());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_LastName(driver).sendKeys(Data.sobrenomeCadastro());
		Cadastro_Page.txtbx_FirstName(driver).click();
		Cadastro_Page.txtbx_FirstName(driver).sendKeys(Data.nomeCadastro());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		NumericalKeyboard.PreencherPhoneNumber(driver);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_State(driver).click();
		Cadastro_Page.txtbx_State(driver).sendKeys(Data.estadoCadastro());
		Cadastro_Page.txtbx_Country(driver).click();
		Scroll.scrollAndClick(driver, Data.paisCadastro());
		Cadastro_Page.txtbx_State(driver).click();
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_Address(driver).click();
		Cadastro_Page.txtbx_Address(driver).sendKeys(Data.enderecoCadastro());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_Cep(driver).sendKeys(Data.cepCadastro());
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Cadastro_Page.txtbx_City(driver).click();
		Cadastro_Page.txtbx_City(driver).sendKeys(Data.cidadeCadastro());
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Scroll.onlyScroll(driver, "REGISTER");
		Scroll.swipe(511, 1326, 511, 706, driver);
		Cadastro_Page.btn_Register(driver).click();
		action.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000))).perform();
		Home_Page.btn_Menu(driver).click();
		action.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000))).perform();
		String screenShotPath = GetScreenShot.capture(driver, "cadastro_valido");
		test.log(LogStatus.PASS, "teste finalizado, print abaixo: " +  test.addScreenCapture(screenShotPath));
		

	}

//	@Ignore
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
		Scroll.swipe(727, 1362, 601, 1736, driver);
		Scroll.scrollAndClick(driver, "REGISTER");
		Cadastro_Page.btn_Register(driver).click();
		action.waitAction(new WaitOptions().withDuration(Duration.ofMillis(4000))).perform();
		test.log(LogStatus.PASS, "fim do teste");
		test.log(LogStatus.PASS, "Print abaixo: " + test.addScreenCapture(screenShotPath));

	}

	@After
	public static void fecharApp() {
		AppManager.closeApp(driver);
	}
	
}
