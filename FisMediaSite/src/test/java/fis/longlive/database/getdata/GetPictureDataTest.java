package fis.longlive.database.getdata;

import fis.longlive.database.getdata.GetPictureData;
import java.sql.Date;
import static junit.framework.Assert.assertNotSame;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GetPictureDataTest extends TestCase {
    public GetPictureDataTest() {
        super();
    }
    
    public static Test suite() {
        return new TestSuite(GetPictureDataTest.class);
    }
    
    public void testGetRowCount() {
        GetPictureData p = new GetPictureData();
        
        assertNotSame(0, p.getPictureRowCount());
    }
    
    public void testPictureInformation() {
        GetPictureData p = new GetPictureData("Great lion");
        
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
