package com.dkatalis.DkatalisAssignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Setup {

	public static Properties config = null;
	public static WebDriver driver = null;
	public static Properties allure = null;
	static Logger logger = Logger.getLogger(Setup.class);
	
	public void LoadConfigProperty() throws IOException {
		config = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/dkatalis/resources/config.properties");
				config.load(ip);
	}

	public void openBrowserAndLaunchUrl(String url) throws Exception {
		LoadConfigProperty();
		if (config.getProperty("browserType").equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get(url);
			
//			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Resources/drivers/geckodriver.exe");
//			//System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"/Resources/drivers/geckodriver.exe");
//			driver = new FirefoxDriver();

		} else if (config.getProperty("browserType").equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(url);
			
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Resources/drivers/chromedriver.exe");
//			driver = new ChromeDriver();

		} else if (config.getProperty("browserType").equals("IE")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.get(url);
//			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/Resources/drivers/IEDriverServer.exe");
//			driver = new InternetExplorerDriver();
		}
	}

	public void maximizeWindow() {

		if (config.getProperty("browserType").equals("Firefox")) {

			logger.info("Window is alredy maximized");
		} else {
			driver.manage().window().maximize();
		}
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void pageLoad(int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	public void setEnv() throws Exception {
		LoadConfigProperty();
		String baseUrl = config.getProperty("siteUrl");
		driver.get(baseUrl);
	}

	

	
}
