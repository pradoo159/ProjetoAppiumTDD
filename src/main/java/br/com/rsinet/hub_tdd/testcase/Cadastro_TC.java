package br.com.rsinet.hub_tdd.testcase;

import java.net.MalformedURLException;
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
import br.com.rsinet.hub_tdd.util.GetScreenShot;
import br.com.rsinet.hub_tdd.util.Screenshot;
import br.com.rsinet.hub_tdd.util.Scroll;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Cadastro_TC {

	ExtentReports extent;
	ExtentTest test;
	private static AndroidDriver<MobileElement> driver;
	private TouchAction<?> action;

	@Before
	public void iniciarApp() throws MalformedURLException {
		driver = AppManager.startApp();
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentScreenshot.html", true);
	}

	@Test
	public void DeveCadastrarUmUsuario() throws Exception {

		action = new TouchAction(driver);
		test = extent.startTest("captureScreenshot");
		Home_Page.btn_Menu(driver).click();
		Home_Page.lnk_Login(driver).click();
		Home_Page.lnk_Cadastrar(driver).click();
		Cadastro_Page.txtbx_Username(driver).click();
		Cadastro_Page.txtbx_Username(driver).sendKeys("pradov1025");
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
		Cadastro_Page.txtbx_State(driver).sendKeys("São Paulo");
		action.tap(PointOption.point(226, 1630)).perform();
		Scroll.scrollAndClick(driver, "Brazil");
		Scroll.swipe(603, 1479, 599, 292, driver);
		Cadastro_Page.txtbx_Address(driver).click();
		Cadastro_Page.txtbx_Address(driver).sendKeys("Avenida dos remédios");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_Cep(driver).sendKeys("06293110");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Cadastro_Page.txtbx_City(driver).click();
		Cadastro_Page.txtbx_City(driver).sendKeys("Osasco");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Scroll.scrollAndClick(driver, "REGISTER");
		action.waitAction(new WaitOptions().withDuration(Duration.ofMillis(4000))).perform();
		Screenshot.TirarPrint(driver, "cadastro_valido");
		test.log(LogStatus.PASS, "Teste Passou");
		String screenShotPath = GetScreenShot.capture(driver, "screenShotName");
		test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenShotPath));

	}

	@Ignore
	@Test
	public void NaoDeveCadastrarUmUsuarioComEmailInvalido() throws Exception {

		action = new TouchAction(driver);

		Home_Page.btn_Menu(driver).click();
		Home_Page.lnk_Login(driver).click();
		Home_Page.lnk_Cadastrar(driver).click();
		Cadastro_Page.txtbx_Username(driver).click();
		Cadastro_Page.txtbx_Username(driver).sendKeys("pradov1025");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_Email(driver).sendKeys("emerson.pradorsinet.com3.br");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Screenshot.TirarPrint(driver, "cadastro_com_email_invalido");
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
		action.tap(PointOption.point(226, 1630)).perform();
		Scroll.scrollAndClick(driver, "Brazil");
		Scroll.swipe(603, 1479, 599, 292, driver);
		Cadastro_Page.txtbx_Address(driver).click();
		Cadastro_Page.txtbx_Address(driver).sendKeys("Avenida dos remédios");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Cadastro_Page.txtbx_Cep(driver).sendKeys("06293110");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Cadastro_Page.txtbx_City(driver).click();
		Cadastro_Page.txtbx_City(driver).sendKeys("Osasco");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Scroll.scrollAndClick(driver, "REGISTER");
		action.waitAction(new WaitOptions().withDuration(Duration.ofMillis(4000))).perform();

	}

	@After
	public void fecharApp() {
		AppManager.closeApp(driver);
		extent.flush();
	}

}
