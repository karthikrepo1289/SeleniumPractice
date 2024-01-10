package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseduoElement_Concept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
//		String jsQuery = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"),'::before').getPropertyValue('content')";
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String reqField = (String) js.executeScript(jsQuery);
//		System.out.println(reqField);
//		System.out.println(checkReqFieldCheck("label[for='input-firstname']", driver));

		String[] lstOfCssSelectors = { "label[for='input-firstname']", "label[for='input-lastname']",
				"label[for='input-email']", "label[for='input-telephone']", "label[for='input-password']",
				"label[for='input-confirm']" };
		for (int i = 0; i < lstOfCssSelectors.length; i++) {
			String reqField = checkReqFieldCheck(lstOfCssSelectors[i], driver);
			if(reqField.contains("*")) {
				System.out.println(lstOfCssSelectors[i].substring(lstOfCssSelectors[i].indexOf("-")+1,lstOfCssSelectors[i].lastIndexOf("'"))+"is a required field");
			}else {
				System.out.println(lstOfCssSelectors[i].substring(lstOfCssSelectors[i].indexOf("-")+1,lstOfCssSelectors[i].lastIndexOf("'"))+"is not a required field");
			}
			
		}

	}

	public static String checkReqFieldCheck(String shareAddress, WebDriver driver) {
		String partOne = "return window.getComputedStyle(document.querySelector(\"";
		String partTwo = shareAddress + "\"),'::before').getPropertyValue('content')";
		String fullPath = partOne + partTwo;

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String reqField = (String) js.executeScript(fullPath);
		return reqField;

	}
}

/**
 * Algorithm Launch Browser Navigate URL Ready with Javascript Get the Pseudo
 * Element Property Return the value and validate
 */
