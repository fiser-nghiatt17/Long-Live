package fis.longlive.database.setdata;

import fis.longlive.database.Data;

public class SetTypeData extends Data {
    public SetTypeData() {
        super("type", "name");
    }
    
    public SetTypeData(String type) {
        this();
        this.fieldValue = type;
    }
    
    public int setTypeID(Integer value) {
        return setTypeData("typeID", value);
    }
    
    public int setName(String value) {
        return setTypeData("name", value);
    }
    
    public int setTypeData(String field, Object value) {
        return setData(field, value);
    }
    
}
