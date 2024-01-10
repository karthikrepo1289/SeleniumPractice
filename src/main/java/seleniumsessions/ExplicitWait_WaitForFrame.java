package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait_WaitForFrame {
	static By address_frame = By.id("frame-one748593425");
	static By address_image = By.id("imageTemplateContainer");
	static By address_proposal = By.id("RESULT_TextField-1");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

		driver.findElement(address_image).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//If frame is available and server able to find it with in 10 seconds then driver automatically switch to frame
		//If server unable to find the frame even after 10 seconds then TimeOutExceptoin raises. (Internally it returns null)
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(address_frame));
		driver.findElement(address_proposal).sendKeys("TESTING");
		
		driver.switchTo().defaultContent();
		
	}

}
