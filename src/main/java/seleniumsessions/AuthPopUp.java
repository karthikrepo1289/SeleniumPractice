package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthPopUp {

	public static WebDriver driver;
	public static String userName ="admin";
	public static String passWord = "admin";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		//protoco+ uername:password + @ + remaining domain name
		driver.get("https://"+userName+":"+passWord+"@the-internet.herokuapp.com/basic_auth");
		
		//Limitation : What if our username or password contains @
	}

}
