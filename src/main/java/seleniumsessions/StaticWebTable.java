package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//Find all the companies and check desired company is present or not.
		List<WebElement> companyList = driver.findElements(By.xpath("//table[@id='customers']//tr/td[1]"));
		for(WebElement company : companyList) {
			if(company.getText().equalsIgnoreCase("Laughing Bacchus Winecellars")) {
				System.out.println("Pas - "+company.getText()+" exists.");
				break;
			}
		}
		
		//Print all the contacts
		String xPath1 = "//table[@id='customers']//tr[";
		String xPath2 = "]/td[2]";
		int rowsCount = driver.findElements(By.xpath("//table[@id='customers']//child::tr")).size();
		WebElement contact;
		for(int i=2;i<=rowsCount;i++) {
			//System.out.println(xPath1+i+xPath2);
			contact = driver.findElement(By.xpath(xPath1+i+xPath2));
			System.out.println(contact.getText());
		}
		
		//Print all the values of WebTable
		List<WebElement> fullDetails = driver.findElements(By.xpath("//table[@id='customers']//child::tr//td"));
		int i=1;
		for(WebElement elmnt : fullDetails) {
			if(i>3) {
				i=1;
				System.out.println(" ");
			}
			if(i<=3) {
			System.out.print(elmnt.getText()+"\t");
			i++;
			continue;
			}
			
		}
	}
}
