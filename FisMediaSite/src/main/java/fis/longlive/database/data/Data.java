package fis.longlive.database.data;

import fis.longlive.database.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Data extends Connect {
    private final String table;
    private final String fieldCondition;
    protected String fieldValue;
    
    public Data(String table, String fieldCondition) {
        this.table = table;
        this.fieldCondition = fieldCondition;
    }
    
    protected int getRowCount() {
        String query = "SELECT * FROM " + table;
        ResultSet rs = queryDB(query, null);
        int count = 0;
        try {
            while (rs.next()) {
                count++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
    
    protected Object getData(String field) {
        try {
            String query = "SELECT " + field 
                           + " FROM " + table
                           + " WHERE " + fieldCondition
                           + " = ?";
            String[] args = new String[] {this.getFieldValue()};
        
            ResultSet rs = queryDB(query, args);
        
            if (rs.next()) {
                return rs.getObject(field);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }

    public String getFieldValue() {
        return this.fieldValue;
    }
}
