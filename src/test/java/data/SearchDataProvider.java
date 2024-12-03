package data;

import org.testng.annotations.DataProvider;

public class SearchDataProvider {
    @DataProvider
    public Object[][] searchChristmasProducts() {
        return new Object[][]{
                { "Craciun", "edge"},

        };
    }
}
