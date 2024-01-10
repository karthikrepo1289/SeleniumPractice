package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CRMTest extends BaseTest {

	// TC One : Validate URL
	@Test(priority = 1)
	public void urlTest() {
		String actURL = driver.getCurrentUrl();
		boolean actResult = actURL.contains("classic");
		Assert.assertTrue(actResult);
	}

	@Test(priority = 2)
	public void titleTest() {
		String expTitle = "Free CRM software for customer relationship management, sales, and support.";
		String actTitle = driver.getTitle();

		Assert.assertEquals(actTitle, expTitle);
	}

	@Test(priority = 3)
	public void loginButtonTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Login']")).isEnabled());
	}

}

/*
 * Precondition : Launch Browser, Launch Application Tests to be performed :
 * Test App URL, Test title, Test Login button Postcondition : Close Browser
 *
 */