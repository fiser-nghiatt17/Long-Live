package fis.longlive.database.data;

public class AlbumData extends Data {
    public AlbumData() {
        super("album", "name");
    }
    
    public AlbumData(String album) {
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
