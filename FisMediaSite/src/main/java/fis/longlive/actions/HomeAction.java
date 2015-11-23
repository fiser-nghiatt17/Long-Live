package fis.longlive.actions;

import fis.longlive.database.process.ProcessAlbum;
import fis.longlive.database.table.Album;
import fis.longlive.models.HomeDisplay;

import java.util.ArrayList;
import java.util.List;

public class HomeAction {
    private List<Album> album;
    private List<HomeDisplay> homeDisplays = new ArrayList<>();
int i=0;
    public String execute() {
        album = ProcessAlbum.selectAllAlbum();
        System.out.println("Album size"+album.size());
        for (Album a : album) {
            if (a.getPictures().size() > 0) {
                homeDisplays.add(new HomeDisplay(a.getPictures().get(0).getPictureURL(), a.getUser().getFullname(), a.getAlbumName(), a.getLikeAmount(), a.getViewAmount()));
            }
            System.out.println(a.getUser().getFullname());
            System.out.println(a.getAlbumName());
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
