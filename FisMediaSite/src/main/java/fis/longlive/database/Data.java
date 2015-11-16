package fis.longlive.database;

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
        
            ResultSet rs = queryDB(query, 
                           new String[] {this.getFieldValue()});
        
            if (rs.next()) {
                return rs.getObject(field);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    protected int setData(String field, Object value) {
        String query = "UPDATE " + table
                       + " SET " + field + " = " + value.toString()
                       + " WHERE " + fieldCondition + " = ?";
            
        return updateDB(query, new String[] {this.getFieldValue()});
    }

    public String getFieldValue() {
        return this.fieldValue;
    }
}
