package fis.longlive.database.data;

public class TypeData extends Data {
    public TypeData() {
        super("type", "name");
    }
    
    public TypeData(String type) {
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
