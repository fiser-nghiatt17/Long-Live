package fis.longlive.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import fis.longlive.database.Connect;
import fis.longlive.models.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;

public class SignUpAction extends ActionSupport implements ModelDriven<User> {

    User newUser = new User();
    Connect connect = new Connect();
    HttpSession session = ServletActionContext.getRequest().getSession();

    public String checkSignUp(){

        //Kiem tra co chua
        String query = "SELECT * FROM user WHERE username = ?";
        String[] loginInfo = new String[1];
        loginInfo[0] = newUser.getUsername();

        ResultSet resultSet = connect.queryDB(query, loginInfo);

        try{
            if (resultSet.next()) {
                newUser.setResult(LOGIN);
                return LOGIN;
            } else{
                String query2 = "INSERT INTO user (fullname, username, password)" +
                                           "VALUES(?, ?, ?)";
                String[] signUpInfo = new String[3];
                signUpInfo[0] = newUser.getFullName();
                signUpInfo[1] = newUser.getUsername();
                signUpInfo[2] = newUser.getPassword();

                connect.insertQueryDB(query2, signUpInfo);

                session.setAttribute("username", newUser.getFullName());
                newUser.setResult(SUCCESS);
                return SUCCESS;
            }
        }catch (Exception e){

        }
        return "";
    }

    @Override
    public User getModel() {
        return newUser;
    }

}
