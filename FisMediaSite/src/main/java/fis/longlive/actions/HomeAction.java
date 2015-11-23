package fis.longlive.actions;

/**
 * Created by Admin on 23/11/2015.
 */
import fis.longlive.database.process.ProcessAlbum;
import fis.longlive.database.table.Album;

import java.util.List;

public class HomeAction {
    private List<Album> album;
    public String execute() {
        album = ProcessAlbum.selectAllAlbum();
        return "success";
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }
}

