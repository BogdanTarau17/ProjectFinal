package data;

import POJO.SearchModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class SearchDataProvider {

    @DataProvider(name = "searchTestDataInput")
    public Iterator<Object[]> searchTestDataInput() throws IOException {
        Collection<Object[]> searchDP = new ArrayList<>();
        File jsonFile = new File("src/test/resources/testData/searchTestDataInput.json");
        ObjectMapper objectMapper = new ObjectMapper();
        SearchModel[] searchModels = objectMapper.readValue(jsonFile, SearchModel[].class);
        for (SearchModel searchModel: searchModels)
            searchDP.add(new Object[]{searchModel});
        return searchDP.iterator();
    }
    @DataProvider
    public Object[][] searchNonexistingProducts() {
        return new Object[][]{
                { "Craciun", "edge"},

        };
    }
}
