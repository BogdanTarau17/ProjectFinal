package tests;

import POJO.RegistrationModel;
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
    @Test(dataProvider = "registrationJsonDataProvider", dataProviderClass = RegistrationDataProvider.class)
    public void registerFailedRegistration(RegistrationModel registrationModel) throws InterruptedException {
        setUp();
    navigateToURL("account/register");
    RegistrationPage registrationPage = new RegistrationPage(driver);
    System.out.println(registrationModel);
    registrationPage.register(registrationModel.getFirstName(), registrationModel.getLastName(), registrationModel.getEmail(),registrationModel.getPassword());
        Thread.sleep(60000);
    if (registrationModel.getRegistrationErr().isEmpty()) {
        System.out.println("Verify register successful");
        Assert.assertTrue(registrationPage.verifyRegistrationSuccessful(registrationModel.getFirstName()));
    } else {
        System.out.println("Verify register failed with message: " + registrationModel.getRegistrationErr());
        Assert.assertTrue(registrationPage.verifyRegistrationFailed(registrationModel.getRegistrationErr()));
    }
}
}


