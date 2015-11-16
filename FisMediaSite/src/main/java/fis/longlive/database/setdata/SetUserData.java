package fis.longlive.database.setdata;

import fis.longlive.database.Data;

public class SetUserData extends Data {
    
    public SetUserData() {
        super("user", "username");
    }
    
    public SetUserData(String user) {
        this();
        this.fieldValue = user;
    }

    public int setUserID(Integer value) {
        return setUserData("userID", value);
    }
    
    public int setUsername(String value) {
        return setUserData("username", value);
    }
    
    public int setPassword(String value) {
        return setUserData("password", value);
    }
    
    public int getFullname(String value) {
        return setUserData("fullname", value);
    }
    
    public int setEmail(String value) {
        return setUserData("email", value);
    }
    
    public int setPrivateID(Boolean value) {
        return setUserData("privateID", value);
    }
    
    private int setUserData(String field, Object value) {
        return setData(field, value);
    }
}
