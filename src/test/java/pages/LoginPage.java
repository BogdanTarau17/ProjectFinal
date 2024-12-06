package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[4]/div[1]/div/button")
    private WebElement signInButton;

    @FindBy(id= "loginInputName")
    private WebElement emailInput;

    @FindBy(id = "loginInputEmail")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement pageIdentifier;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/div/ul/li/text()")
    private WebElement errorMessageElement;

    @FindBy(xpath = "//*[@id=\"login\"]/h2")
    private WebElement loginText;

    @FindBy(xpath = "//*[@id=\"shopify-section-header-template\"]/header/div[3]/div/div/div[3]/div[3]/div/button")
    private WebElement myAccount;

    @FindBy(xpath = "//*[@id=\"shopify-section-header-template\"]/header/div[3]/div/div/div[3]/div[3]/div/div/div[2]/ul/li[2]/a/i")
    private WebElement logOutOption;
    public LoginPage(WebDriver driver, WebElement pageIdentifier) {
        super(driver);
        this.pageIdentifier = pageIdentifier;
        PageFactory.initElements(driver, this);
    }
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void login(String username, String password) {
        System.out.println("Waiting for login page to load");
        waitUntilElementVisible(pageIdentifier);
        this.enterUsername(username);
        this.enterPassword(password);
        this.submit();
    }
    public void loginFailed(String username, String password){
        System.out.println("Waiting for login page to load");
        waitUntilElementVisible(pageIdentifier);
        this.enterUsername(username);
        this.enterPassword(password);
        driver.findElement(By.id("loginInputName")).sendKeys(Keys.ENTER);
        loginText.click();
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
    public void openMyAccount(){
        waitUntilElementVisible(myAccount);
        System.out.println("Open My account menu");
        myAccount.click();

    }
    public void logout(){
        waitUntilElementVisible(logOutOption);
        System.out.println("Logout");
        logOutOption.click();
    }
    public boolean verifyLogoutSuccessful() {
        try{
        boolean isVisible = waitUntilElementVisible(By.xpath("//*[@id=\"tt-pageContent\"]/div/div/h1")).isDisplayed();
            System.out.println("Logout successful");
            return isVisible;
        } catch (Exception e) {
            System.err.println("Logout verification failed: " + e.getMessage());
            return false;
        }
    }
}