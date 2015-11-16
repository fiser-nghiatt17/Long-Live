package fis.longlive.database.setdata;

import fis.longlive.database.Data;

public class SetAlbumData extends Data {
    public SetAlbumData() {
        super("album", "name");
    }
    
    public SetAlbumData(String album) {
        this();
        this.fieldValue = album;
    }
    
    public int setAlbumID(Integer value) {
        return setAlbumData("albumID", value);
    }
    
    public int setName(String value) {
        return setAlbumData("name", value);
    }
    
    public int setUser(Integer value) {
        return setAlbumData("user", value);
    }
    
    public int setCategory(Integer value) {
        return setAlbumData("category", value);
    }
    
    public int setAlbumData(String field, Object value) {
        return setData(field, value);
    }
    
}
