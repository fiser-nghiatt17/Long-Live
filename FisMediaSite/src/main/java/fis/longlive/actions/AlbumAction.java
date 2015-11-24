package fis.longlive.actions;

import com.opensymphony.xwork2.ActionSupport;
import fis.longlive.database.process.ProcessAlbum;
import fis.longlive.database.table.Album;
import fis.longlive.database.table.Picture;
import fis.longlive.database.table.User;

import java.util.List;

/**
 * Created by nghiatran on 11/22/15.
 */
public class AlbumAction extends ActionSupport {
    private int albumId;
    private Album album;
    private User author;
    private List<Picture> pictures;

    public String execute() {
        album = ProcessAlbum.selectAlbum(albumId);
        pictures = album.getPictures();
        author = album.getUser();
        return SUCCESS;
    }

    public String editAlbum(){
        album = ProcessAlbum.selectAlbum(albumId);
        pictures = album.getPictures();
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
}
