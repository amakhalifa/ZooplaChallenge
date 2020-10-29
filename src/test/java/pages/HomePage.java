package pages;

import base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Testbase {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search-input-location")
    private WebElement searchLocation;

    @FindBy(id = "search-submit")
    private WebElement searchSubmit;

    public void setSearchLocation(String location) {
        searchLocation.sendKeys(location);
    }

    public ForSalePage clickSearchSubmit() {
        searchSubmit.click();
        return new ForSalePage();
    }
}
