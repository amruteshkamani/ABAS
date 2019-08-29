package com.ABAS.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{
	static WebDriver driver;
	static Properties prop;
	
	public TestBase() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\TSTS ABAS\\ABAS Git\\ABAS\\ABAStest\\src\\main\\java\\com\\ABAS\\Config\\config.properties");
		prop.load(fis);
	}

	public void initilization()
	{
		String browserName = prop.getProperty("Browser");
		browserName.equals("chrome");
		System.setProperty("webriver.chrome.driver", "E:\\Syntizen\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
