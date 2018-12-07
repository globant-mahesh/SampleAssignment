package com.org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.org.configs.ConfigFileReader;

import java.util.List;

public class SearchFlight {

    private WebDriverWait wait;
    private WebDriver driver;
    private ConfigFileReader confReader = new ConfigFileReader();
    public SearchFlight(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 40);
        this.driver = driver;

    }

    @FindBy(how = How.ID, using = "OneWay")
    private WebElement btnOneWay;

    @FindBy(how = How.ID, using = "RoundTrip")
    private WebElement btnRoundTrip;

    @FindBy(how = How.ID, using = "MultiCity")
    private WebElement btnMultiCity;

    @FindBy(how = How.ID, using = "FromTag")
    private WebElement from;

    @FindBy(how = How.XPATH, using = ".//li[@role='presentation']//a[contains(text(),'Pune')]")
    private WebElement fromListSelect;

    @FindBy(how = How.XPATH, using = ".//li[@role='presentation']//a[contains(text(),'Mumbai')]")
    private WebElement toListSelect;

    @FindBy(how = How.ID, using = "ToTag")
    private WebElement to;

    @FindBy(how = How.ID, using = "DepartDate")
    private WebElement departDatePicker;

    @FindBy(how = How.XPATH, using = ".//div[@id='ui-datepicker-div']/child::div[2]//td")
    private List<WebElement> allDates;

    @FindBy(how = How.XPATH, using = ".//dt//strong[text()='Return on']/following::input[1]")
    private WebElement returnDatePicker;


    @FindBy(how = How.ID, using = "Adults")
    private WebElement adults;

    @FindBy(how = How.ID, using = "Childrens")
    private WebElement children;

    @FindBy(how = How.ID, using = "Infants")
    private WebElement infants;

    @FindBy(how = How.ID, using = "SearchBtn")
    private WebElement btnSearchFlight;

    @FindBy(how = How.XPATH,using = ".//li[contains(@class,'listItem')]/parent::ul")
    private WebElement tblFlight;

    public void navigateToSearchPage() {
        driver.get(confReader.getApplicationURL());
        driver.manage().window().maximize();
    }

    public void oneWaySelect() {
        btnOneWay.click();
    }

    public void returnSelect() {
        btnRoundTrip.click();
    }

    public void enterLocations() throws InterruptedException {
        from.sendKeys("Pune");
       // Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(fromListSelect));
        fromListSelect.click();
        to.sendKeys("Mumbai");
        wait.until(ExpectedConditions.visibilityOf(toListSelect));
        toListSelect.click();
    }

    public void selectDepartDate(String Date) {
        departDatePicker.click();
        for (WebElement ele : allDates) {
            if (ele.getText().equalsIgnoreCase(Date)) {
                ele.click();
                break;
            }
        }
    }

    public void passengerDetails() {
        Select selectPass = new Select(adults);
        selectPass.selectByIndex(2);
    }

    public void selectReturnDate(String Date) {
        returnDatePicker.click();
        for (WebElement ele : allDates) {
            if (ele.getText().equalsIgnoreCase(Date)) {
                ele.click();
                break;
            }
        }
    }

    public DisplayFlightOptions searchFlight() {

        btnSearchFlight.click();
        return new DisplayFlightOptions(driver);
    }
}