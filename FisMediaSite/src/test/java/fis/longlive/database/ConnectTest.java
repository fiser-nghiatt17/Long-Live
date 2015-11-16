package fis.longlive.database;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ConnectTest extends TestCase {
    public ConnectTest() {
        super();
    }
    
    public static Test suite() {
        return new TestSuite(ConnectTest.class);
    }
    
    public void testIsConnected() {
        Connect c = new Connect();
        
        assertTrue(c.isConnected());
    }
    
    public void testIsNotConnected() {
        Connect c = new Connect();
        c.setCon(null);
        
        assertFalse(c.isConnected());
    }
    
    public void testUpdateDBFailure() {
        String query = "Something update statement";
        
        Connect c = new Connect();
        
        assertEquals(0, c.updateDB(query, null));
    }
    
    public void testUpdateDBSuccess() {
        String query = "UPDATE user SET userID = ? WHERE userID = ?";
        
        String[] args = new String[]{"1", "1"};
        
        Connect c = new Connect();
        
        assertEquals(1, c.updateDB(query, args));
    }
    
    public void testQueryDBFailure() {
        String query = "Something query statement";
        
        Connect c = new Connect();
        
        assertNull(c.queryDB(query, null));
    }
    
    public void testQueryDBSuccess() {
        String query = "SHOW tables";
        
        Connect c = new Connect();
        
        assertNotNull(c.queryDB(query, null));
    }
}
