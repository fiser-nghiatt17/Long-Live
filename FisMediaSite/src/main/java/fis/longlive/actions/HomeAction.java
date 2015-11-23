package fis.longlive.actions;

/**
 * Created by Admin on 23/11/2015.
 */
import fis.longlive.database.process.ProcessAlbum;
import fis.longlive.database.table.Album;
import fis.longlive.models.HomeDisplay;

import java.util.ArrayList;
import java.util.List;

public class HomeAction {
    private List<Album> album;
    private List<HomeDisplay> homeDisplays = new ArrayList<>();
    public String execute() {
        album = ProcessAlbum.selectAllAlbum();
        for (Album a : album) {
            if (a.getPictures().size() > 0) {
                homeDisplays.add(new HomeDisplay(a.getPictures().get(0).getPictureURL(), a.getUser().getFullname(), a.getAlbumName(), a.getLikeAmount(), a.getViewAmount()));
            }
        }
        return "success";
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    public List<HomeDisplay> getHomeDisplays() {
        return homeDisplays;
    }

    public void setHomeDisplays(List<HomeDisplay> homeDisplays) {
        this.homeDisplays = homeDisplays;
    }
}

