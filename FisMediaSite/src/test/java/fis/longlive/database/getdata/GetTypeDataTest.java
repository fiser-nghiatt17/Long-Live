package fis.longlive.database.getdata;

import fis.longlive.database.getdata.GetTypeData;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GetTypeDataTest extends TestCase {
    public GetTypeDataTest() {
        super();
    }
    
    public static Test suite() {
        return new TestSuite(GetAlbumDataTest.class);
    }
    
    public void testGetRowCount() {
        GetTypeData t = new GetTypeData();
        
        assertNotSame(0, t.getTypeRowCount());
    }
    
    public void testTypeInformation() {
        GetTypeData a = new GetTypeData("natural");
        
        assertEquals(1, a.getTypeID());
        assertEquals("natural", a.getName());
    }
}
