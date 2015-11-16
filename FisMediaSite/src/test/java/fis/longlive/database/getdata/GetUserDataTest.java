package fis.longlive.database.getdata;

import fis.longlive.database.getdata.GetUserData;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GetUserDataTest extends TestCase {
    public GetUserDataTest() {
        super();
    }
    
    public static Test suite() {
        return new TestSuite(GetUserDataTest.class);
    }
    
    public void testGetRowCount() {
        GetUserData u = new GetUserData();
        
        assertNotSame(0, u.getUserRowCount());
    }
    
    public void testUserInformation() {
        GetUserData u = new GetUserData("tuanna80");
        
        assertEquals(7, u.getUserID());
        assertEquals("tuanna80", u.getUsername());
        assertEquals("tuanna80", u.getPassword());
        assertEquals("tuanna80@fpt.com.vn", u.getEmail());
        assertEquals("Nguyen Anh Tuan", u.getFullname());
        assertEquals(true, u.getPrivateID());
    }
}
