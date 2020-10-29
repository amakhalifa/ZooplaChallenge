package pages;

import base.Testbase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForSalePage extends Testbase {

    public ForSalePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div#content > ul > li > div > div:nth-child(2) > a")
    private List<WebElement> priceList;

    @FindBy(xpath = "//select[@name='results_sort']")
    WebElement sortSelect;

    public Select selectFilter() {
        return new Select(sortSelect);
    }


    public void sortResult()  {
        selectFilter().selectByValue("highest_price");
    }

    public String getCurrentSortValue(){
        return (selectFilter().getFirstSelectedOption().getText());
    }

    public PropertyDtlPage getPropertybyPosition(int i) {
        WebElement property = priceList.get(i-1);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", property);
        return new PropertyDtlPage();
    }

    public List<String> getRawPrice() {
        List<String> rawPriceList = new ArrayList<String>();
        Iterator<WebElement> it = priceList.listIterator();
        while (it.hasNext()) {
            String s = it.next().getText();
            rawPriceList.add(s.split(" ")[0]);
        }
        System.out.println(rawPriceList);
        return rawPriceList;
    }



}
