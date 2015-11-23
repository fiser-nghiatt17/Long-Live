package fis.longlive.actions;

import com.opensymphony.xwork2.ActionSupport;
import fis.longlive.database.process.ProcessUser;
import fis.longlive.database.table.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class ProfileAction extends ActionSupport {
    private String username;
    private User user;
    private HttpSession session = ServletActionContext.getRequest().getSession();

    public String execute() {
        user = ProcessUser.selectUser(username);
        if (user == null)
            return LOGIN;
//        String username = (String) session.getAttribute("username");
//        if (username == null)
//            return LOGIN;
        return SUCCESS;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
