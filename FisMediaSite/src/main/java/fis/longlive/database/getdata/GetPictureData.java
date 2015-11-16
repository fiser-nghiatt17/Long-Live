package fis.longlive.database.getdata;

import fis.longlive.database.Data;
import java.sql.Date;

public class GetPictureData extends Data {
    public GetPictureData() {
        super("picture", "title");
    }
    
    public GetPictureData(String picture) {
        this();
        this.fieldValue = picture;
    }
    
    public int getPictureRowCount() {
        return getRowCount();
    }
    
    public int getPictureID() {
        return (Integer) getPictureData("pictureID");
    }
    
    public String getTitle() {
        return (String) getPictureData("title");
    }
    
    public int getAlbum() {
        return (Integer) getPictureData("album");
    }
    
    public String getUrl() {
        return (String) getPictureData("url");
    }
    
    public Date getDateUpdate() {
        return (Date) getPictureData("dateUpdate");
    }
    
    public int getView() {
        return (Integer) getPictureData("view");
    }
    
    public String getDescription() {
        return (String) getPictureData("description");
    }
    
    public Object getPictureData(String field) {
        return getData(field);
    }
    
}
