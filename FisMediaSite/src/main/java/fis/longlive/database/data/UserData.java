package fis.longlive.database.data;

public class UserData extends Data {
    
    public UserData() {
        super("user", "username");
    }
    
    public UserData(String user) {
        this();
        this.fieldValue = user;
    }

    public int getUserRowCount() {
        return getRowCount();
    }

    public int getUserID() {
        return (Integer) getUserData("userID");
    }
    
    public String getUsername() {
        return (String) getUserData("username");
    }
    
    public String getPassword() {
        return (String) getUserData("password");
    }
    
    public String getFullname() {
        return (String) getUserData("fullname");
    }
    
    public String getEmail() {
        return (String) getUserData("email");
    }
    
    public boolean getPrivateID() {
        return (Boolean) getUserData("privateID");
    }
    
    private Object getUserData(String field) {
        return getData(field);
    }
}
