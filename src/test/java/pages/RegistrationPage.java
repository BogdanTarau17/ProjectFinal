package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"create_customer\"]/div[6]/div[1]/div/button")
    private WebElement createButton;
    @FindBy(xpath = "//*[@id=\"loginInputName\"]")
    private WebElement firstNameInput;
    @FindBy(xpath = "//*[@id=\"loginLastName\"]")
    private WebElement lastNameInput;
    @FindBy(id = "loginInputEmail")
    private WebElement emailInput;
    @FindBy(id = "loginInputPassword")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"tt-pageContent\"]/div/div/h1")
    private WebElement pageIdentifier;
    @FindBy(className = "errors")
    private WebElement errorMessageElement;

    public RegistrationPage(WebDriver driver, WebElement createButton, WebElement firstNameInput, WebElement lastNameInput, WebElement pageIdentifier) {
        super(driver);
        this.createButton = createButton;
        this.firstNameInput = firstNameInput;
        this.lastNameInput = lastNameInput;
        this.pageIdentifier = pageIdentifier;
    }

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void register(String firstName, String lastName, String email, String password) {
        System.out.println("Waiting for login page to load");
        waitUntilElementVisible(pageIdentifier);
        this.enterFirstName(firstName);
        this.enterLastName(lastName);
        this.enterEmail(email);
        this.enterPassword(password);
        this.submit();
    }
    public void enterFirstName(String firstName){
        waitUntilElementVisible(firstNameInput);
        System.out.println("Enter first name" + firstName);
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        waitUntilElementVisible(lastNameInput);
        System.out.println("Enter last name" + lastName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }
    public void enterEmail(String email){
        waitUntilElementVisible(emailInput);
        System.out.println("Enter email" + email);
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void enterPassword(String password){
        waitUntilElementVisible(passwordInput);
        System.out.println("Enter password" + password);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(createButton));
        System.out.println("Create");
        createButton.click();
    }
    public boolean verifyRegistrationSuccessful(String username) {
        String xpath = "//*[@id=\"tt-pageContent\"]/div/div/h1";

        WebElement welcomeMessage = waitUntilElementVisible(By.xpath(xpath));
        System.out.println("Welcome message displayed: " + welcomeMessage.getText());
        return welcomeMessage.isDisplayed();
    }

    public boolean verifyRegistrationFailed(String errorMessage) {
        waitUntilElementVisible(errorMessageElement);
        System.out.println("Error message displayed: " + errorMessageElement.getText());
        return errorMessageElement.getText().equalsIgnoreCase(errorMessage);
    }
}





