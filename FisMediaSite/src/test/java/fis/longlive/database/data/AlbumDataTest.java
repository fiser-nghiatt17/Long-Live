package fis.longlive.database.data;

import static junit.framework.Assert.assertNotSame;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AlbumDataTest extends TestCase {
    public AlbumDataTest() {
        super();
    }
    
    public static Test suite() {
        return new TestSuite(AlbumDataTest.class);
    }
    
    public void testGetRowCount() {
        AlbumData a = new AlbumData();
        
        assertNotSame(0, a.getRowCount());
    }
    
    public void testAlbumInformation() {
        AlbumData a = new AlbumData("lion");
        
        assertEquals(1, a.getAlbumID());
        assertEquals(1, a.getUser());
        assertEquals("lion", a.getName());
        assertEquals(4, a.getCategory());
    }
}
