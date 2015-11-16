package fis.longlive.database.setdata;

import fis.longlive.database.Data;
import java.sql.Date;

public class SetPictureData extends Data {
    public SetPictureData() {
        super("picture", "title");
    }
    
    public SetPictureData(String picture) {
        this();
        this.fieldValue = picture;
    }
    
    public int setPictureID(Integer value) {
        return setPictureData("pictureID", value);
    }
    
    public int setTitle(String value) {
        return setPictureData("title", value);
    }
    
    public int setAlbum(Integer value) {
        return setPictureData("album", value);
    }
    
    public int setUrl(String value) {
        return setPictureData("url", value);
    }
    
    public int setDateUpdate(Date value) {
        return setPictureData("dateUpdate", value);
    }
    
    public int setView(Integer value) {
        return setPictureData("view", value);
    }
    
    public int setDescription(String value) {
        return setPictureData("description", value);
    }
    
    public int setPictureData(String field, Object value) {
        return setData(field, value);
    }
    
}
