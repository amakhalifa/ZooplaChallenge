package testcases;

import base.Testbase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PropertyDtlPage;
import pages.ForSalePage;
import pages.HomePage;

public class ZooPlaChallengeTest extends Testbase {

    HomePage homePage;
    ForSalePage forSalePage;
    PropertyDtlPage propertyDtlPage;

    @BeforeMethod
    public void setup(){
        initConfiguration();
        homePage = new HomePage();
        forSalePage = new ForSalePage();
        propertyDtlPage = new PropertyDtlPage();
    }


    @Test
    public void challangeOne() {
        acceptCookies();
        homePage.setSearchLocation("London");
        homePage.clickSearchSubmit();

        forSalePage.sortResult();
        Assert.assertEquals(forSalePage.getCurrentSortValue(), "Highest price");
        forSalePage.getRawPrice();
        forSalePage.getPropertybyPosition(5);

        propertyDtlPage.agentInfo();
        String agent = propertyDtlPage.getAgentName();
        propertyDtlPage.clickAgentName();
        String customer = propertyDtlPage.getCustomerName();

        Assert.assertTrue(agent.contains(customer));

    }
}
