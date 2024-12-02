package tests;

import POJO.RegistrationModel;
import data.LoginDataProvider;
import data.RegistrationDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest{

@Test(dataProvider = "registrationDataProvider", dataProviderClass = RegistrationDataProvider.class)
    public void testSuccessfulRegistration(String firstName, String lastName, String email, String password, String browser){
        getBrowser(browser);
        getBaseURL();
        navigateToURL("account/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.register(firstName, lastName, email, password);
        System.out.println("Verify registration successful");
        boolean isRegistrationSuccessful = registrationPage.verifyRegistrationSuccessful(firstName);
        Assert.assertTrue(isRegistrationSuccessful, "Registration was not successful.");

    }
    @Test(dataProvider = "registerXMLDataProvider", dataProviderClass = RegistrationDataProvider.class)
    public void testRegistrationWithMissingPassword(RegistrationModel registrationData) {
        getBrowser();
        getBaseURL();
        navigateToURL("account/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.register(
                registrationData.getFirstName(),
                registrationData.getLastName(),
                registrationData.getEmail(),
                registrationData.getPassword()
        );
        System.out.println("Registration is not complete");
        boolean isErrorDisplayed = registrationPage.verifyRegistrationFailed("Parolă nu poate fi necompletat");
        Assert.assertTrue(isErrorDisplayed, "Error message not displayed.");
    }
}


