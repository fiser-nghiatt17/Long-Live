package fis.longlive.database.data;

import java.sql.Date;

public class PictureData extends Data {
    public PictureData() {
        super("picture", "title");
    }
    
    public PictureData(String picture) {
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
