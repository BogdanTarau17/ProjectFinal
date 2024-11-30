package tests;

import data.LoginDataProvider;
import org.glassfish.jaxb.runtime.v2.runtime.output.SAXOutput;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{


    @Test(dataProvider = "loginDataProviderSuccessfully", dataProviderClass = LoginDataProvider.class)
    public void testLogin(String username, String password, String browser) {
        getBrowser(browser);
        getBaseURL();
        navigateToURL("account/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        System.out.println("Verify login successful");
        Assert.assertTrue(loginPage.verifyLoginSuccessful(username));
    }
    @Test (dataProvider = "loginDataProviderFail", dataProviderClass = LoginDataProvider.class)
    public void testLoginFailed (String username, String password, String browser) {
        getBrowser(browser);
        getBaseURL();
        navigateToURL("account/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        System.out.println("Verify login fail");
        Assert.assertTrue(loginPage.verifyLoginFailed(username));
    }
}

