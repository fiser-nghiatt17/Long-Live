package fis.longlive.database.data;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TypeDataTest extends TestCase {
    public TypeDataTest() {
        super();
    }
    
    public static Test suite() {
        return new TestSuite(AlbumDataTest.class);
    }
    
    public void testGetRowCount() {
        TypeData t = new TypeData();
        
        assertNotSame(0, t.getRowCount());
    }
    
    public void testTypeInformation() {
        TypeData a = new TypeData("natural");
        
        assertEquals(1, a.getTypeID());
        assertEquals("natural", a.getName());
    }
}
