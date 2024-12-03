package POJO;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;

@Getter
public class AccountModel {
    private String username;
    private String password;

    public AccountModel() {
    }
    public AccountModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @XmlElement
    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }
}

