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

    /* ####################################################### XML DATA PROVIDER ##########################################  */
    @DataProvider(name = "loginXMLDataProvider")
    public Iterator<Object[]> loginXMLDataProvider() throws JAXBException {
        Collection<Object[]> dp = new ArrayList<>();
//      here we will map json to LoginModel
        File xmlFile = new File("src/test/resources/testData/testDataInput.xml");

        LoginModel loginModel = (LoginModel) unMarshalObjectModel(xmlFile, LoginModel.class);

//       adding to data provider
        dp.add(new Object[]{loginModel});
        return dp.iterator();
    }

    private Object unMarshalObjectModel(File f, Class<?>... classesToBeBound) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);

//        loading xml and mapped based on tags added on LoginModel and AccountModel
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller.unmarshal(f);
    }

    @DataProvider
    public Object[][] loginDataProviderSuccessfully() {
        return new Object[][]{
                // username, password, browser
                {"IOnel@yah", "IOnel@", "chrome"},
                // {"IOnel@yahoo.com", "inc", "chrome"}
        };
    }

    @DataProvider
    public Object[][] loginDataProviderFail() {
        return new Object[][]{
                {"IOnel@yah", "111", "chrome"},
        };


    }

}

