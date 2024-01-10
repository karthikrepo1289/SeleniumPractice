package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");

		//JavaScriptUtil js = new JavaScriptUtil(driver);

//		String title_webpage = js.getTitleByJavaScript("return document.title");
//		System.out.println("Webpage title is "+title_webpage);

//		js.generateJSAlert("Hello This is java script alert");
//		Thread.sleep(4000);
//		driver.switchTo().alert().accept();

//		Thread.sleep(4000);
//		js.navigateUsingJSScript("back");
//		Thread.sleep(4000);
//		js.navigateUsingJSScript("refresh");
//		Thread.sleep(4000);
//		js.navigateUsingJSScript("forward");

		JavascriptExecutor jst = (JavascriptExecutor) driver;
//		String javaScript = "return document.documentElement.innerText;";
//		System.out.println(jst.executeScript(javaScript).toString());
		
		Thread.sleep(5000);
//		//window.scrollTo(0,document.body.scrollHeight);
//		jst.executeScript("window.scrollTo(0,document.body.scrollHeight);");
//		Thread.sleep(5000);
//		//window.scrollTo(document.body.scrollHeight,0);
//		jst.executeScript("window.scrollTo(document.body.scrollHeight,0);");
		
//		int height = 500;
//		jst.executeScript("window.scrollTo(0," +height+ ");");
		
//		jst.executeScript("window.scrollTo(0,document.body.scrollHeight/2);");
		
		//WebElement element = driver.findElement(By.linkText("English (US)"));
//		WebElement element = driver.findElement(By.xpath("//h3[text()='Marketing Automation']"));
//		jst.executeScript("arguments[0].scrollIntoView(true);", element);
		
		//document.body.style.zoom = '80%'
		//arguments[0].style.border = '3px solid red';
		WebElement element = driver.findElement(By.xpath("//input[@value='Login']"));
		String bgColor = element.getCssValue("backgroundColor");
		System.out.println(bgColor);
		Thread.sleep(6000);
//		jst.executeScript("arguments[0].style.border = '8px solid red';", element);
		for(int i=0; i<10; i++) {
			changeColor(element, jst,"rgb(0,800,0)");
			changeColor(element, jst, bgColor);
		}
		
	}
	private static void changeColor(WebElement elmnt, JavascriptExecutor js, String color) {
		//arguments[0].style.color = 'red';
		js.executeScript("arguments[0].style.backgroundColor ='" + color + "'", elmnt);
		try {
			Thread.sleep(50);
		}catch(InterruptedException e) {
			
		}
	}
}
