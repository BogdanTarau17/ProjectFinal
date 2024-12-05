package tests;

import POJO.LoginModel;
import data.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    @Test(dataProvider = "loginSQLDataProvider",dataProviderClass = LoginDataProvider.class)
    public void loginWithSQLAsDataSource(LoginModel loginModel)
     {
        setUp();
        navigateToURL("account/login");

        LoginPage loginPage = new LoginPage(driver);
        System.out.println(loginModel);
        loginPage.login(loginModel.getAccount().getUsername(), loginModel.getAccount().getPassword());

        if (loginModel.getLoginErr().isEmpty()) {
            System.out.println("Verify login successful");
            Assert.assertTrue(loginPage.verifyLoginSuccessful(loginModel.getAccount().getUsername()));
        } else {
            System.out.println("Verify login failed with message: " + loginModel.getLoginErr());
            Assert.assertTrue(loginPage.verifyLoginFailed(loginModel.getLoginErr()));
        }
    }
    
    

    @Test (dataProvider = "loginDataProviderFail", dataProviderClass = LoginDataProvider.class)
    public void testLoginFailed (String username, String password, String browser) {
        getBrowser(browser);
        getBaseURL();
        navigateToURL("account/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFailed(username, password);
        System.out.println("Verify login fail");
        Assert.assertTrue(loginPage.verifyLoginFailed(username));
    }

    @Test(dependsOnMethods = {"loginWithSQLAsDataSource"})
    public void logoutTest() {
        setUp();
        navigateToURL("account/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openMyAccount();
        loginPage.logout();
        System.out.println("Verify logout was successful");
        Assert.assertTrue(loginPage.verifyLogoutSuccessful(), "Logout was not successful!");
    }

    }

