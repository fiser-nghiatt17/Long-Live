package fis.longlive.actions;

import com.opensymphony.xwork2.ActionSupport;
import fis.longlive.database.process.ProcessAlbum;
import fis.longlive.database.process.ProcessPicture;
import fis.longlive.database.process.ProcessUser;
import fis.longlive.database.table.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class ProfileAction extends ActionSupport {
    private String username;
    private User user;
    private HttpSession session = ServletActionContext.getRequest().getSession();
    private int albumId;
    private int pictureId;

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

    public String deleteAAlbum(){
        ProcessAlbum.deleteAlbum(albumId);
        return "success";
    }

    public String deleteAPicture(){
        ProcessPicture.deletePicture(pictureId);
        return "success";
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

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
}
