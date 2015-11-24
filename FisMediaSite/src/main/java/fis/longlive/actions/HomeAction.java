package fis.longlive.actions;

/**
 * Created by Admin on 23/11/2015.
 */
import fis.longlive.database.process.ProcessAlbum;
import fis.longlive.database.table.Album;

import java.util.Collections;
import java.util.List;

public class HomeAction {
    private List<Album> album;
    private String test = ":V";
    public String execute() {
        album = ProcessAlbum.selectAllAlbum();
        return "success";
    }

    public String mostView(){
        album = ProcessAlbum.selectAllAlbum();
        Collections.sort(album);
        //album=album.subList(0,8);
        return "success";
    }

    public String mostLike(){
        album = ProcessAlbum.selectAllAlbum();
        Collections.sort(album,Album.albumlike);
        //album=album.subList(0,8);
        return "success";
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }
}

