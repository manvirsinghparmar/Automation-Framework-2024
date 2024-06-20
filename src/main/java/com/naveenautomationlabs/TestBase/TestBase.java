package com.naveenautomationlabs.TestBase;

import java.time.Duration;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	private final String browser = "Chrome";
	private final String URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";

	// This method intialise the Webdriver instance
	public void intialise() {

		intialiseWebdriver();
		// Maximise Window
		driver.manage().window().maximize();
		// Manage Timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// Load Webpage
		driver.get(URL);

	}

	private void intialiseWebdriver() {
		switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			throw new InvalidArgumentException("Pass Correct Browser name");
		}
	}

	// Method to close the browser
	public void tearDown() {
		driver.quit();
	}

}
