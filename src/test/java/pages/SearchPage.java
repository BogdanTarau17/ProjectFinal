package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"shopify-section-header-template\"]/header/div[3]/div/div/div[3]/div[1]/div/button")
    private static WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"shopify-section-header-template\"]/header/div[3]/div/div/div[3]/div[1]/div/div/div/form/div[1]/input[2]")
    private static WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"shopify-section-template--23764489306487__main\"]/div/div/h1/span")
    private WebElement successfulGeneralSearch;

    @FindBy(xpath = "//*[@id=\"shopify-section-template--23764489306487__main\"]/div/div/span")
    private static WebElement invalidSearch;

    @FindBy(xpath = "//*[@id=\"shopify-section-template--23764489306487__main\"]/div/div/span")
    private static WebElement noResultsMessage;

    @FindBy( xpath = "//*[@id=\"shopify-section-header-template\"]/header/div[3]/div/div/div[1]/a")
    private static WebElement pageIdentifier;

    public SearchPage(WebDriver driver, WebElement searchButton, WebElement searchInput) {
        super(driver);
        this.searchButton = searchButton;
        this.searchInput = searchInput;
        this.invalidSearch = invalidSearch;

    }
    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void searchButtonIsDisplayed(){
        waitUntilElementVisible(searchButton);
        System.out.println("Click on the Search button");
        searchButton.click();
    }
    public void searchInputIsDisplayed(){
        waitUntilElementVisible(searchInput);
        System.out.println("Insert your data ");
        searchInput.clear();
        searchInput.sendKeys();

    }
    public boolean searchSuccessful(String searchContent) {
        waitUntilElementVisible(searchButton);
        System.out.println("Click on the Search button");
        searchButton.click();
        waitUntilElementVisible(searchInput);
        searchInput.clear();
        searchInput.sendKeys(searchContent);
        searchInput.sendKeys(Keys.ENTER);
        waitUntilElementVisible(successfulGeneralSearch);
        System.out.println("Search input: " + searchContent);
        return successfulGeneralSearch.isDisplayed();
    }
    public boolean invalidSearch(String searchContent, String browser) {
        waitUntilElementVisible(searchButton);
        System.out.println("Click on the Search button");
        searchButton.click();
        waitUntilElementVisible(searchInput);
        searchInput.clear();
        searchInput.sendKeys(searchContent);
        searchInput.sendKeys(Keys.ENTER);
        waitUntilElementVisible(noResultsMessage);
        System.out.println("Search input: " + searchContent);
        return noResultsMessage.isDisplayed();
    }
    public boolean isNoResultsMessageDisplayed() {
        waitUntilElementVisible(noResultsMessage);
        return noResultsMessage.isDisplayed();
    }


}
