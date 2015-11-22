package fis.longlive.actions;

import com.opensymphony.xwork2.ActionSupport;
import fis.longlive.database.process.ProcessUser;
import fis.longlive.database.table.User;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;


@SuppressWarnings("serial")
public class UserAction extends ActionSupport{

    private String username;
    private String password;
    private String fullName;
    private String result;

    HttpSession session = ServletActionContext.getRequest().getSession();

    public String execute() throws SQLException {
        User user = ProcessUser.selectUser(username);
        if(user != null){
            if(password.equals(user.getPassword())){
                setSession(user);
                result = SUCCESS;
            } else result = LOGIN;

        }else{
            result = LOGIN;
        }
        return result;
    }

    public String signUp(){
        if(ProcessUser.selectUser(username)!= null){
            result = LOGIN;
        }else{
            User user = new User();
            user.setFullname(fullName);
            user.setUsername(username);
            user.setPassword(password);
            ProcessUser.insertUser(user);
            setSession(user);
            result = SUCCESS;
        }
        return result;
    }

    public String logout() {
        session.removeAttribute("username");
        session.removeAttribute("fullName");
        return SUCCESS;
    }

    public void setSession(User user){
        session.setAttribute("fullName", user.getFullname());
        session.setAttribute("username", user.getUsername());
    }

    public String checkSession() {
        String login = (String) session.getAttribute("username");
        if (login == null) {
            return LOGIN;
        } else {
            return SUCCESS;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
