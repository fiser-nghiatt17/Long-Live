package fis.longlive.database.getdata;

import fis.longlive.database.Data;

public class GetAlbumData extends Data {
    public GetAlbumData() {
        super("album", "name");
    }
    
    public GetAlbumData(String album) {
        this();
        this.fieldValue = album;
    }
    
    public int getAlbumRowCount() {
        return getRowCount();
    }
    
    public int getAlbumID() {
        return (Integer) getAlbumData("albumID");
    }
    
    public String getName() {
        return (String) getAlbumData("name");
    }
    
    public int getUser() {
        return (Integer) getAlbumData("user");
    }
    
    public int getCategory() {
        return (Integer) getAlbumData("category");
    }
    
    public Object getAlbumData(String field) {
        return getData(field);
    }
    
}
