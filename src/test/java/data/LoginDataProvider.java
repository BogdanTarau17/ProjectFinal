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
    @DataProvider(name = "loginSQLDataProvider")
    public Iterator<Object[]> loginSQLDataProvider() throws JAXBException, IOException, CsvException, SQLException {
        Collection<Object[]> dp = new ArrayList<>();
        DatabaseUtils databaseUtils = new DatabaseUtils();
        Connection connection = databaseUtils.connect();
        Statement statement = databaseUtils.getStatement(connection);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM login");
        while (resultSet.next()) {
            LoginModel loginModel = new LoginModel(databaseUtils.getElementFromDB(resultSet, "username"),
                    databaseUtils.getElementFromDB(resultSet, "password"),
                    databaseUtils.getElementFromDB(resultSet, "loginError"));
            dp.add(new Object[]{loginModel});
        }
        return dp.iterator();
    }
}

