package fis.longlive.database.getdata;

import static junit.framework.Assert.assertNotSame;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GetAlbumDataTest extends TestCase {
    public GetAlbumDataTest() {
        super();
    }
    
    public static Test suite() {
        return new TestSuite(GetAlbumDataTest.class);
    }
    
    public void testGetRowCount() {
        GetAlbumData a = new GetAlbumData();
        
        assertNotSame(0, a.getAlbumRowCount());
    }
    
    public void testAlbumInformation() {
        GetAlbumData a = new GetAlbumData("lion");
        
        assertEquals(1, a.getAlbumID());
        assertEquals(1, a.getUser());
        assertEquals("lion", a.getName());
        assertEquals(4, a.getCategory());
    }
}
