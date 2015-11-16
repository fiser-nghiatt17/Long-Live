package fis.longlive.database.getdata;

import fis.longlive.database.Data;

public class GetTypeData extends Data {
    public GetTypeData() {
        super("type", "name");
    }
    
    public GetTypeData(String type) {
        this();
        this.fieldValue = type;
    }
    
    public int getTypeRowCount() {
        return getRowCount();
    }
    
    public int getTypeID() {
        return (Integer) getTypeData("typeID");
    }
    
    public String getName() {
        return (String) getTypeData("name");
    }
    
    public Object getTypeData(String field) {
        return getData(field);
    }
    
}
