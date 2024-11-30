package data;

import POJO.LoginModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegistrationDataProvider {
    @DataProvider
    public Object[][] registrationDataProvider() {
        return new Object[][]{
                {"", "incorrect", "chrome"},
                {"", "incorrect", "chrome"}
        };
    }
    @DataProvider(name = "loginJsonDataProvider")
    public Iterator<Object[]> loginJsonDataProvider() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
        File jsonFile = new File("src/test/resources/testData/testDataInput.json");
        ObjectMapper objectMapper = new ObjectMapper();
        LoginModel[] loginModelList = objectMapper.readValue(jsonFile, LoginModel[].class);
        for (LoginModel lm : loginModelList)
            dp.add(new Object[]{lm});
        return dp.iterator();
    }
}
