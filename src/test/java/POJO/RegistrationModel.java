package POJO;

import org.openqa.selenium.devtools.v126.fedcm.model.Account;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;

@Getter
@XmlRootElement
public class RegistrationModel {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public RegistrationModel(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "RegistrationModel: {\n" +
                "firstName='" + firstName + "',\n" +
                "lastName='" + lastName + "',\n" +
                "email='" + email + "',\n" +
                "password='******'\n" +
                '}';
    }
}
