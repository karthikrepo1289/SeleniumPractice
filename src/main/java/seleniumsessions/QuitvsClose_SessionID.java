package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitvsClose_SessionID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver(); //Eg : SID =123
		driver.get("https://www.google.com"); //SIDD =123
		
		//Session ID = Null. Server is still up.
		driver.quit();  //SID = Null after executing.
		
		//What will be the session id.
		//Runtime Exception : org.openqa.selenium.NoSuchSessionException: "Session ID is null".
		/*String title = driver.getTitle(); SID = null
		System.out.println(title);*/
		
		//Solution : Re launch the browser
		driver = new ChromeDriver(); //Eg : SID = 456
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.close(); //Eg : SID = 456
		//Runtime Exception : org.openqa.selenium.NoSuchSessionException: "invalid session id"
		/*title = driver.getTitle(); SID = 456
		System.out.println(title);*/
		
		driver = new ChromeDriver(); //Eg : SID = 789
		driver.get("https://www.google.com");
		title = driver.getTitle();
		System.out.println(title);
	}

}
