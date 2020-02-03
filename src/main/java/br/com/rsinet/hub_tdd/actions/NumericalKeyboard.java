package br.com.rsinet.hub_tdd.actions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class NumericalKeyboard {
	
	public static void PreencherPhoneNumber(AndroidDriver driver) {
		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_1));
		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_3));
		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_5));
		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_4));
		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_6));
		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_7));
		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_7));
		
	}

}
