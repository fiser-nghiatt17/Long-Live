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

    private String isOwner = "false";

    public String execute() {
        user = ProcessUser.selectUser(username);
        if (user == null)
            return LOGIN;
        String owner = (String) session.getAttribute("username");
        if (owner == null)
            return LOGIN;
        if(owner.equals(username))
            isOwner = "true";
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

    public String getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(String isOwner) {
        this.isOwner = isOwner;
    }
}
