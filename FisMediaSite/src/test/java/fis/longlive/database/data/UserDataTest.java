package fis.longlive.database.data;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class UserDataTest extends TestCase {
    public UserDataTest() {
        super();
    }
    
    public static Test suite() {
        return new TestSuite(UserDataTest.class);
    }
    
    public void testGetRowCount() {
        UserData u = new UserData();
        
        assertNotSame(0, u.getRowCount());
    }
    
    public void testUserInformation() {
        UserData u = new UserData("tuanna80");
        
        assertEquals(7, u.getUserID());
        assertEquals("tuanna80", u.getUsername());
        assertEquals("tuanna80", u.getPassword());
        assertEquals("tuanna80@fpt.com.vn", u.getEmail());
        assertEquals("Nguyen Anh Tuan", u.getFullname());
        assertEquals(true, u.getPrivateID());
    }
}
