package fis.longlive.models;

/**
 * Created by Admin on 23/11/2015.
 */
public class HomeDisplay {
    private String picURL;
    private String fullname;
    private String albumname;
    private int view;
    private int like;

    public HomeDisplay(String picURL, String fullname, String albumname, int like, int view) {
        this.picURL = picURL;
        this.fullname = fullname;
        this.albumname = albumname;
        this.like = like;
        this.view = view;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}

