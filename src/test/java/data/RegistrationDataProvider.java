package data;

import POJO.LoginModel;
import POJO.RegistrationModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegistrationDataProvider {
    private File f;
    private Class<?>[] classesToBeBound;

    @DataProvider
    public Object[][] registrationDataProvider() {
        return new Object[][]{
                {"Ion", "Vasile", "Ionel21@yahoo.com", "Ion123", "chrome"},
                //{"", "incorrect", "chrome"}
        };
    }

    @DataProvider(name = "registrationJsonDataProvider")
    public Iterator<Object[]> registrationJsonDataProvider() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
        File jsonFile = new File("src/test/resources/testData/testDataInput.json");

        ObjectMapper objectMapper = new ObjectMapper();
        RegistrationModel[] registrationModelList = objectMapper.readValue(jsonFile, RegistrationModel[].class);

        for (RegistrationModel lm : registrationModelList) {
            dp.add(new Object[]{lm});
        }
        return dp.iterator();
    }
}
