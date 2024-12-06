package tests;

import POJO.SearchModel;
import data.SearchDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends BaseTest{

    @Test(dataProvider = "searchTestDataInput", dataProviderClass = SearchDataProvider.class)
    public void testSuccessfulSearch(SearchModel searchModel) {
        setUp();
        driver.navigate().to(baseURL);
        SearchPage searchPage = new SearchPage(driver);
        System.out.println("Search Model: " + searchModel.getSearchInput());
        boolean isSearchSuccessful = searchPage.searchSuccessful(searchModel.getSearchInput());
        System.out.println("Searching with input: " + searchModel.getSearchInput());
        Assert.assertTrue(isSearchSuccessful, "Search was not successful for input: " + searchModel.getSearchInput());
    }
    @Test(dataProvider = "searchNonexistingProducts", dataProviderClass = SearchDataProvider.class)
    public void testInvalidSearch(String item, String browser){
        setUp();
        driver.navigate().to(baseURL);
        SearchPage searchPage = new SearchPage(driver);
        boolean invalidSearch =searchPage.invalidSearch(item, browser);
        System.out.println("Message CĂUTAREA DVS. NU RESTINE REZULTATE is displayed for invalid search");
        Assert.assertTrue(invalidSearch,
                " 'CĂUTAREA DVS. NU RESTINE REZULTATE' message was not displayed for search item: " + item);

    }
}
