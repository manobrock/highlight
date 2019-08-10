package highlighelement.highlighelement;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class highlighelement {
	String driverpath ="H:\\selenium\\chromedriver_win32\\chromedriver.exe";
	public static WebDriver driver;
	String url = "https://demo.testfire.net/login.jsp";
	
	@Test
	
	public void highlight() {
		try {
	
		WebElement username= driver.findElement(By.name("uid"));
		highLightElement(username);
		username.sendKeys("Jsmith");
		WebElement password = driver.findElement(By.name("passw"));
		highLightElement(password);
		password.sendKeys("Demo1234");
		WebElement login = driver.findElement(By.name("btnSubmit"));
		highLightElement(login);
		login.click();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	
	private void highLightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','background:orange;border:2px solid red;');",element);
		// TODO Auto-generated method stub
		
	}
	
@Before
	public void openbrowser() {
		System.setProperty("webdriver.chrome.driver",driverpath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}

}
