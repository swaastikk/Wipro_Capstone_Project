package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

import java.util.List;

public class CitySearchPage {

    private WebDriver driver;
    
    //Constructor code here
    public CitySearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators code here
    @FindBy(xpath = "//input[@placeholder='Search for your city']")
	private WebElement citySearchBox;

	@FindBy(xpath = "//div[@class='sc-fv93km-0 cPDWyb']//div[1]//div[1]")
	private WebElement firstSuggestedCity;

    @FindBy(xpath = "//div[@class='sc-5d56x9-0 hIDoFD']//span")  
    private List<WebElement> searchResults;

    @FindBy(xpath = "//div[@class='sc-fv93km-1 fZhJNQ']")   
    private WebElement errorMessage;

    @FindBy(xpath = "//li//p")   
    private List<WebElement> cityIcons;

    @FindBy(xpath = "//div[@id='common-header-region']//span")   
    private WebElement cityDropdown;

    @FindBy(xpath = "//p[text()='View All Cities']")
    private WebElement viewAllCitiesLink;

    @FindBy(xpath = "//li[@class='sc-1a0jimq-0 hhOIxv']")  
    private List<WebElement> allCitiesList;


    // Methods code here
    public void selectCity(String cityName) {
    	WaitUtils.waitForVisibility(driver, citySearchBox).sendKeys(cityName);
	}

    public boolean isCityPresentInResults(String cityName) {
        for (WebElement city : searchResults) {
            if (city.getText().equalsIgnoreCase(cityName)) {
                return true;
            }
        }
        return false;
    }
    
    public void clickOnFirstResult() {
    	WaitUtils.waitForClickability(driver, searchResults.get(0)).click();
    }
    
    public String getTextFromCityDropdown() {
    	return WaitUtils.waitForVisibility(driver, cityDropdown).getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void selectCityByIcon(String cityName) {
        for (WebElement cityIcon : cityIcons) {
        	System.out.println(cityIcon.getText());
            if (cityIcon.getText().toLowerCase().contains(cityName.toLowerCase())) {
                cityIcon.click();
                break;
            }
        }
    }

    public void openAllCitiesList() {
    	WaitUtils.waitForClickability(driver, viewAllCitiesLink).click();
    }

    public boolean isCityPresentInAllCities(String cityName) {
        for (WebElement city : allCitiesList) {
            if (city.getText().equalsIgnoreCase(cityName)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isCityPresentInPopularCities(String cityName) {
    	for (WebElement city : cityIcons) {
    		if (city.getText().equalsIgnoreCase(cityName)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    
}
