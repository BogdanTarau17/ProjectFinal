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

    @DataProvider(name = "registerXMLDataProvider")
    public Iterator<Object[]> registerXMLDataProvider() throws JAXBException {
        Collection<Object[]> dp = new ArrayList<>();
        File xmlFile = new File("src/test/resources/testData/testDataInput.xml");
        RegistrationModel registrationModel = (RegistrationModel) unMarshalObjectModel(xmlFile, LoginModel.class);
        dp.add(new Object[]{registrationModel});
        return dp.iterator();
    }

    private Object unMarshalObjectModel(File f, Class<?>... classesToBeBound) throws JAXBException {
        this.f = f;
        this.classesToBeBound = classesToBeBound;
        JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);

//        loading xml and mapped based on tags added on LoginModel and AccountModel
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller.unmarshal(f);
    }
}
