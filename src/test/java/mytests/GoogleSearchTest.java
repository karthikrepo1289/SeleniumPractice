package mytests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

	// TC One : Test serach box is enabled for search or not.
	@Test(priority = 1)
	public void searchBoxTest() {
		WebElement elmnt = driver.findElement(By.id("APjFqb"));
		Assert.assertTrue(elmnt.isEnabled(), "Search text box is not enabled");
	}

	@Test(priority = 2)
	public void supportLangTest() {
		ArrayList<WebElement> lnks = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		ArrayList<String> lngs = new ArrayList<String>();

		for (WebElement link : lnks) {
			lngs.add(link.getText());
		}
		Assert.assertTrue(lngs.contains("తెలుగు"), "Telugu language is not supported");
	}

}
