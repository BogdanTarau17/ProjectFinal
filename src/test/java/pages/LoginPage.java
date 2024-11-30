package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[4]/div[1]/div/button")
    private WebElement signInButton;
    @FindBy(xpath= "//*[@id=\"loginInputName\"]")
    private WebElement emailInput;
    @FindBy(xpath = "//*[@id=\"loginInputEmail\"]")
    private WebElement passwordInput;
    @FindBy(xpath = "//h2[contains(text(),'LOG IN')]")
    private WebElement pageIdentifier;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/div")
    private WebElement errorMessageElement;
    public LoginPage(WebDriver driver, WebElement pageIdentifier) {
        super(driver);
        this.pageIdentifier = pageIdentifier;
        PageFactory.initElements(driver, this);
    }

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void login(String username, String password) {
        System.out.println("Waiting for login page to load");
        waitUntilElementVisible(pageIdentifier);
        this.enterUsername(username);
        this.enterPassword(password);
        this.submit();
    }
    public void enterUsername(String username) {
        waitUntilElementVisible(emailInput);
        System.out.println("Enter email:" + username);
        emailInput.clear();
        emailInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(passwordInput);
        System.out.println("Enter password:" + password);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        System.out.println("Log in");
        signInButton.click();
    }

    public boolean verifyLoginSuccessful(String username) {
        String xpath = "//*[@id=\"tt-pageContent\"]/div/div/h1";

        WebElement welcomeMessage = waitUntilElementVisible(By.xpath(xpath));
        System.out.println("Welcome message displayed: " + welcomeMessage.getText());
        return welcomeMessage.isDisplayed();
    }

    public boolean verifyLoginFailed(String errorMessage) {
        waitUntilElementVisible(errorMessageElement);
        System.out.println("Error message displayed: " + errorMessageElement.getText());
        return errorMessageElement.getText().equalsIgnoreCase(errorMessage);
    }

}