package com.org.stepDefs;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.org.configs.ConfigFileReader;



public class Hooks{

    
	
	public ConfigFileReader confReader = new ConfigFileReader();
	public static Scenario scenario;
	public static WebDriver driver;  

    @Before
    public void initializeTest(Scenario scenarioObj) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
       System.setProperty("webdriver.chrome.driver",confReader.getDriverPath());
       driver = new ChromeDriver();
    //	System.setProperty("webdriver.chrome.driver","C:\\Users\\Thiyaneswaran_Manoha\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	//base.driver = new ChromeDriver(options);

        System.out.println("This is before scenario");
        scenario = scenarioObj;
    }

    @After
    public void tearDown(Scenario scenarioObj) {
        String basePath  = System.getProperty("user.dir");
        String screenshotFilePath = basePath + "\\target\\cucumber-report-html\\screenshot\\" + scenario.getName() +".png";
        final byte[] shots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(shots, "image/png");
        System.out.println("This is after scenario");
        driver.close();

    }
}
