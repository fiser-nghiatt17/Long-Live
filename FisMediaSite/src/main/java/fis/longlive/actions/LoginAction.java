package fis.longlive.actions;

import com.opensymphony.xwork2.ActionSupport;

import fis.longlive.database.Connect;

import org.apache.struts2.interceptor.SessionAware;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements SessionAware {

    private String username;
    private String password;
    Map<String, Object> sessionMap;

    public String execute() throws SQLException {
        Connect connect = new Connect();
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        String[] loginInfo = new String[2];
        loginInfo[0] = username;
        loginInfo[1] = password;
        ResultSet resultSet = connect.queryDB(query, loginInfo);
        if (resultSet.next()) {
            sessionMap.put("login", username);
            return SUCCESS;
        } else
            return LOGIN;
    }

    public String checkSession() {
        String login = (String) sessionMap.get("login");

        if (login == null) {
            return LOGIN;
        } else {
            return SUCCESS;
        }
    }

    public Map<String, Object> getSession() {
        return sessionMap;
    }

    public void setSession(Map<String, Object> map) {
        this.sessionMap = map;
    }

    public String logout() {
        sessionMap.remove("login");
        return SUCCESS;
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
}
