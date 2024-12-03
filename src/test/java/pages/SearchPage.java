package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

import javax.naming.directory.SearchResult;

public class SearchPage extends BasePage{

@FindBy(xpath = "//*[@id=\"shopify-section-header-template\"]/header/div[2]/div/div/div[3]/div[1]/div/button")
private WebElement searchButton;
@FindBy(xpath = "//*[@id=\"shopify-section-header-template\"]/header/div[2]/div/div/div[3]/div[1]/div/div/div/form/div[1]/input[2]")
private WebElement searchInput;
@FindBy(xpath = "//*[@id=\"shopify-section-template--23764489306487__main\"]/div/div/h1")
private WebElement successfulGeneralSearch;
@FindBy (xpath = "//*[@id=\"shopify-section-template--23764489306487__main\"]/div/div/h1")
private WebElement emptySearch;


    public SearchPage (WebDriver driver, WebElement searchButton, WebElement searchField) {
        super(driver);
        this.searchButton = searchButton;
        this.searchInput = searchInput;
        this.successfulGeneralSearch  = successfulGeneralSearch;
        this.emptySearch = emptySearch;

    }
    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void clickSearchButton() {
        searchButton.click();
    }

    public void enterSearchTerm(String searchTerm) {
        searchInput.clear();
        searchInput.sendKeys(searchTerm);
    }


    public static void performSearch(String searchTerm) {
        clickSearchButton();
        enterSearchTerm(searchTerm);
        searchInput.submit();
    }


    public String getSuccessfulSearchResult() {
        return successfulGeneralSearch.getText();
    }

    public static String getEmptySearchMessage() {
        return emptySearch.getText();
    }
}

