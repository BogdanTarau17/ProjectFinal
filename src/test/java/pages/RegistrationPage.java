package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public RegistrationPage(WebDriver driver, WebElement createButton, WebElement firstNameInput, WebElement lastNameInput, WebElement pageIdentifier) {
        super(driver);
        this.createButton = createButton;
        this.firstNameInput = firstNameInput;
        this.lastNameInput = lastNameInput;
        this.pageIdentifier = pageIdentifier;
    }

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void register(String firstName, String lastName, String email, String password) {
        System.out.println("Waiting for login page to load");
        waitUntilElementVisible(pageIdentifier);
        this.enterFirstName(firstName);
        this.enterLastName(lastName);
        this.enteremail(email);
        this.enterPassword(password);
        this.submit();
    }
    public void enterFirstName(String firstName){
        waitUntilElementVisible(firstNameInput);
        System.out.println("Enter first name" + firstName);
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

}





