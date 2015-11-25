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
    private int numberOfLoading = 0;

    private List<Album> albums;
    private int numberOfPiceturePerRq = 5;
    private int startIndex;
    private int endIndex;

    public String execute() {
        albums = ProcessAlbum.selectAllAlbum();
        boots();
        album = albums.subList(startIndex, endIndex);
        return "success";
    }

    public String mostView(){
        albums = ProcessAlbum.selectAllAlbum();
        Collections.sort(albums);
        boots();
        album = albums.subList(startIndex, endIndex);
        return "success";
    }

    public String mostLike(){
        albums = ProcessAlbum.selectAllAlbum();
        Collections.sort(albums,Album.albumlike);
        boots();
        album = albums.subList(startIndex, endIndex);
        return "success";
    }

    public void boots(){
        startIndex = numberOfLoading*numberOfPiceturePerRq;
        endIndex = startIndex + numberOfPiceturePerRq;

        if (endIndex > albums.size())
            endIndex = albums.size();

        if (startIndex >= albums.size())
            startIndex = albums.size();
    }
    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    public int getNumberOfLoading() {
        return numberOfLoading;
    }

    public void setNumberOfLoading(int numberOfLoading) {
        this.numberOfLoading = numberOfLoading;
    }
}

