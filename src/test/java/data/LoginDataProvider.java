package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.exceptions.CsvException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import POJO.LoginModel;
import org.testng.annotations.DataProvider;
import utils.CSVUtils;
import utils.DatabaseUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    /* ####################################################### JSON DATA PROVIDER ##########################################  */

    @DataProvider(name = "loginJsonDataProvider")
    public Iterator<Object[]> loginJsonDataProvider() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
//      here we will map json to LoginModel
        File jsonFile = new File("src/test/resources/testData/testDataInput.json");

        ObjectMapper objectMapper = new ObjectMapper();
        LoginModel[] loginModelList = objectMapper.readValue(jsonFile, LoginModel[].class);

        for (LoginModel lm : loginModelList)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }

    @DataProvider
    public Object[][] loginDataProviderSuccessfully() {
        return new Object[][]{
                // username, password, browser
                {"IOnel@yahoo.com", "IOnel@", "edge"},
                 {"IOnel@yahoo.com", "ionellll", "chrome"}
        };
    }

    @DataProvider
    public Object[][] loginDataProviderFail() {
        Object[][] objects = {
                {"IOnel@yahoo.com", "1234566", "chrome"},
        };
        return objects;


    }

}

