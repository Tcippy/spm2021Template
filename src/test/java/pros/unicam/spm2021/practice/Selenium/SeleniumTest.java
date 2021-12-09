package pros.unicam.spm2021.practice.Selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

class SeleniumTest {

	static String browser;
	static String projectPath;
	
	static WebDriver driver;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 projectPath = System.getProperty("user.dir");
	}
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		//if(System.getProperty("os.name").equals("Mac OS X")) {
		//System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/mac/chromedriver");
		//}
		/* if(System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/java/pros/unicam/spm2021/practice/chromedriver.exe");
		}
		driver = new ChromeDriver(); */
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-no-sandbox");
		options.addArguments("--disable-sev-shm-usage");
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

	@Test
	//@Disabled
	void checkProsSite() throws InterruptedException {
		
		driver.get("http://localhost:8080/spm2021/");

		Thread.sleep(3000);
		
		String at = driver.getTitle();
		String et = "SPM 2021";
		
		//System.out.println(at);		
		Thread.sleep(3000);

		Assert.assertEquals(et,at);
		
	}
	
	@Test
	@Disabled
	void checkProsSiteSearch() throws InterruptedException {
		
		// navigate your driver to mail.google.com
		driver.get("http://pros.unicam.it/");

		Thread.sleep(3000);
		
		//Find Element by className
		driver.findElement(By.className("toggle-search")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.className("search")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.className("search")).sendKeys("bprove"+ "\n");

		Thread.sleep(4000);
		Boolean bool=true;
		List<WebElement> list = driver.findElements(By.className("type-portfolio-title"));
		for(WebElement element : list){
			if(!element.getText().toLowerCase().contains("bprove"))
			bool= false;
		}

		assertTrue(bool);
		
			
	}
	
	@Test
	//@Disabled
	void checkThisWebAppTitle() throws InterruptedException {
		
		driver.get("http://localhost:8080/spm2021/");

		Thread.sleep(3000);
		
		String at = driver.getTitle();
		String et = "SPM 2021";
		
		//System.out.println(at);		
		Thread.sleep(4000);

		Assert.assertEquals(et,at);
		
	}

}
