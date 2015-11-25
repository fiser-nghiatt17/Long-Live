package fis.longlive.actions;

import com.opensymphony.xwork2.ActionSupport;
import fis.longlive.database.process.ProcessAlbum;
import fis.longlive.database.process.ProcessUser;
import fis.longlive.database.table.Album;
import fis.longlive.database.table.Picture;
import fis.longlive.database.table.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by nghiatran on 11/22/15.
 */
public class AlbumAction extends ActionSupport {
    private int albumId;
    private Album album;
    private User author;
    private List<Picture> pictures;
    private int like;
    private String isOwner;

    public String execute() {
        album = ProcessAlbum.selectAlbum(albumId);
        ProcessAlbum.updateViewAmount(albumId, album.getViewAmount() + 1);
        album = ProcessAlbum.selectAlbum(albumId);
        pictures = album.getPictures();
        author = album.getUser();
        return SUCCESS;
    }

    public String editAlbum(){
        album = ProcessAlbum.selectAlbum(albumId);
        pictures = album.getPictures();

        author = album.getUser();
        HttpSession session = ServletActionContext.getRequest().getSession();
        if(author.getUsername().equals(session.getAttribute("username")))
            isOwner = "true";
        else isOwner = "false";

        return "success";
    }

    public String likeAlbum() {
        album = ProcessAlbum.selectAlbum(albumId);
        ProcessAlbum.updateLikeAmount(albumId, album.getLikeAmount() + like);
        return "success";
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(String isOwner) {
        this.isOwner = isOwner;
    }

}
