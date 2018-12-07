package com.org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.org.base.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DisplayFlightOptions {

    private WebDriverWait wait;
    private WebDriver driver;

    public DisplayFlightOptions(WebDriver driver) {
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, 40);
        this.driver = driver;
    }

    @FindBy(how = How.XPATH,using = ".//p[text()='Your search results are ready.']")
    private WebElement resultsReady;

    @FindBy(how = How.XPATH,using = ".//li[contains(@class,'listItem')]/table/tbody[2]/tr[1]")
    private List<WebElement> allFlights;

    @FindBy(how = How.XPATH,using = ".//div[contains(@class,'listItem')]//table[@class='resultUnitMini']")
    private List<WebElement> allReturnFlights;

    public void getFlightDetails() throws Exception {
       driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
        if(allFlights.size()>0 ||allReturnFlights.size()>0) {
            System.out.println("\nFlight details displayed to the user");
        } else {
            throw new Exception("\nFlight details not displayed");
        }
    }

    public void writeFlightDetails() throws IOException {
        wait.until(ExpectedConditions.invisibilityOf(resultsReady));
        int i =0;
        ArrayList<String> details = new ArrayList<String>();
        for (WebElement ele:allFlights) {
            //Fetch first 5 options for the user
            if (i < 5) {
                details.add(ele.findElement(By.className("arrive")).getText());
                details.add(ele.findElement(By.className("depart")).getText());
                details.add(ele.findElement(By.className("price")).getText());
                i++;
            }
        }
        new CommonUtil().writeExcelDat(details);

    }
}
