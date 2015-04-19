import java.io.IOException;

import android.os.RemoteException;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;

public class CalTest extends UiAutomatorTestCase {
	
	public void testBase() throws UiObjectNotFoundException, RemoteException {
		UiDevice device = getUiDevice();
		device.wakeUp();
		
		device.pressHome();
		try {
			Runtime.getRuntime().exec("am start -n home.jmstudios.calc/.Main");
		}catch (IOException e) {
			e.printStackTrace();
		}
		sleep(1000);
		device.pressBack();

		
		UiObject buttonCE = new UiObject(new UiSelector().text("CE"));
		assertTrue("Button CE is not found", buttonCE.exists());
		UiObject button1 = new UiObject(new UiSelector().text("1"));
		assertTrue("Button 1 is not found", button1.exists());
		UiObject button3 = new UiObject(new UiSelector().text("3"));
		assertTrue("Button 3 is not found", button3.exists());
		UiObject button7 = new UiObject(new UiSelector().text("7"));
		assertTrue("Button 7 is not found", button7.exists());
		UiObject button8 = new UiObject(new UiSelector().text("8"));
		assertTrue("Button 8 is not found", button8.exists());
		UiObject buttonPlus = new UiObject(new UiSelector().text("+"));
		assertTrue("Button + is not found", buttonPlus.exists());
		UiObject buttonMultiply = new UiObject(new UiSelector().text("*"));
		assertTrue("Button * is not found", buttonMultiply.exists());
		UiObject buttonDivide = new UiObject(new UiSelector().text("/"));
		assertTrue("Button / is not found", buttonDivide.exists());
		UiObject buttonEqual = new UiObject(new UiSelector().text("="));
		assertTrue("Button = is not found", buttonEqual.exists());
		UiObject edittext = new UiObject(new UiSelector().resourceId("home.jmstudios.calc:id/editText1"));
		assertTrue("TextBox is not found", edittext.exists());
		
		device.pressBack();
		buttonCE.click();
		sleep(100);
		button7.click();
		sleep(100);
		buttonMultiply.click();
		sleep(100);
		button8.click();
		sleep(100);
		buttonPlus.click();
		sleep(100);
		button3.click();
		sleep(100);
		buttonEqual.click();
		sleep(100);
		assertTrue("result != 59", edittext.getText().equals("59"));
		
		device.pressMenu();
		sleep(1000);
		UiObject frame = new UiObject(new UiSelector().resourceId("android:id/expanded_menu"));
		assertTrue("Menu Panel is not found", frame.exists());
		
		UiObject buttonSeeting = frame.getChild(new UiSelector().className("android.widget.LinearLayout").index(1));
		assertTrue("Item Setting is not found", buttonSeeting.exists());
		buttonSeeting.click();
		sleep(2000);
		
		UiObject buttonPrecision = new UiObject(new UiSelector().text("Precision"));
		assertTrue("Item Precision is not found", buttonPrecision.exists());
		buttonPrecision.click();
		sleep(100);
		UiObject editTextPrecision = new UiObject(new UiSelector().resourceId("android:id/edit"));
		editTextPrecision.clearTextField();
		sleep(1000);
		device.pressKeyCode(12);
		sleep(100);
		UiObject buttonOK = new UiObject(new UiSelector().resourceId("android:id/button1"));
		assertTrue("Button OK is not found", buttonOK.exists());
		buttonOK.click();
		sleep(100);
		device.pressBack();
		sleep(100);
		buttonCE.click();
		sleep(100);
		button1.click();
		sleep(100);
		buttonDivide.click();
		sleep(100);
		button3.click();
		sleep(100);
		buttonEqual.click();
		sleep(100);
		assertTrue("result != 0.33333", edittext.getText().equals("0.33333"));
		
		buttonCE.click();
		sleep(100);
		UiObject functionPanel = new UiObject(new UiSelector().resourceId("home.jmstudios.calc:id/handle"));
		assertTrue("Panel Function is not found", functionPanel.exists());
		functionPanel.click();
		sleep(100);
		UiObject buttonSin = new UiObject(new UiSelector().text("sin"));
		assertTrue("Button SIN is not found", buttonSin.exists());
		buttonSin.click();
		sleep(100);
		functionPanel.click();
		sleep(100);
		device.pressKeyCode(16);
		device.pressKeyCode(7);
		sleep(100);
		buttonEqual.click();
		sleep(100);
		assertTrue("result != 1", edittext.getText().equals("1"));
		sleep(200);
		
	}
}
