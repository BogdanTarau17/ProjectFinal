package POJO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;

@Getter
@XmlRootElement
public class LoginModel {
    private AccountModel account;
    private String loginErr;
    public LoginModel() {
    }
    public LoginModel(String username, String password, String loginErr) {
        this.account = new AccountModel(username, password);
        this.loginErr = loginErr;
    }
//    @XmlElement
//    public void setAccount(AccountModel account) {
//        this.account = account;
//    }
//    @XmlElement
//    public void setLoginErr(String loginErr) {
//        this.loginErr = loginErr;
//    }
    @Override
    public String toString() {
        return "LoginModel value: {\n" +
                "account:{\nusername" + account.getUsername() + ",\n password=" + account.getPassword() +
                "\n}, \n loginErr='" + loginErr + '\n' +
                '}';
    }
}