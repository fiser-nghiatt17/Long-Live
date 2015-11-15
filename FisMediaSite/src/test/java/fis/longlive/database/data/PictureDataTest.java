package fis.longlive.database.data;

import java.sql.Date;
import static junit.framework.Assert.assertNotSame;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PictureDataTest extends TestCase {
    public PictureDataTest() {
        super();
    }
    
    public static Test suite() {
        return new TestSuite(PictureDataTest.class);
    }
    
    public void testGetRowCount() {
        PictureData p = new PictureData();
        
        assertNotSame(0, p.getRowCount());
    }
    
    public void testPictureInformation() {
        PictureData p = new PictureData("Great lion");
        
        assertEquals(1, p.getPictureID());
        assertEquals("Great lion", p.getTitle());
        assertEquals(1, p.getAlbum());
        assertEquals("http://localhost/picture/great_lion.jpg", 
                     p.getUrl());
        assertEquals(Date.valueOf("2015-11-14"), p.getDateUpdate());
        assertEquals(34, p.getView());
        assertEquals("A big lion", p.getDescription());
    }
}
