package pages;

import base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyDtlPage extends Testbase {

    public PropertyDtlPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.dp-sidebar-wrapper__contact > div.ui-agent > a.ui-agent__details > div > h4")
    private WebElement agentName;

    @FindBy(css = "div.dp-sidebar-wrapper__contact > div.ui-agent > a.ui-agent__details > div > img")
    private WebElement agentLogo;

    @FindBy(css = "div.dp-sidebar-wrapper__contact > div.ui-agent > p > a")
    private WebElement agentNmr;

    @FindBy(css = "div#content > div > h1 > b:nth-child(1)")
    WebElement customerName;

    public void agentInfo(){
        System.out.println("Agent Name: " + agentName.getText());
        System.out.println("Agent Company: " + agentLogo.getAttribute("alt"));
        System.out.println("Agent Number: " + agentNmr.getAttribute("href"));
    }

    public String getAgentName() {
        return (agentName.getText());
    }

    public void clickAgentName() {
        agentName.click();
    }

    public String getCustomerName(){
        return (customerName.getText());
    }


}
