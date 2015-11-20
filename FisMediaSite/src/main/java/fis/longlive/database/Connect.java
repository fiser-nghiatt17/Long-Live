package fis.longlive.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {
	private Connection con;
	private PreparedStatement ps;
	
	public Connect() {
		try {
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        connectToDB();
        } catch (InstantiationException e) {
	        System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
	        System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public boolean isConnected() {
        return con != null;
	}
	
	private void connectToDB() {
		try {
			String url = "jdbc:mysql://localhost/longlive";
	        con = DriverManager.getConnection(url, "longlive", "longlive");
        } catch (SQLException e) {
	        System.out.println(e.getMessage());
        }
	}
	
	private void prepare(String query, Object[] args) {
		try {
            ps = con.prepareStatement(query);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
        } catch (SQLException e) {
	        System.out.println(e.getMessage());
        }
	}
	
	public ResultSet queryDB(String query, Object[] args) {
		prepare(query, args);
		try {
	        return ps.executeQuery();
        } catch (SQLException e) {
	        System.out.println(e.getMessage());
        }
        
        return null;
	}

	public int insertQueryDB(String query, Object[] args) {
		prepare(query, args);
		try {
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public int updateDB(String sql, Object[] args) {
		prepare(sql, args);
		try {
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
        
        return 0;
	}
    
    public void setCon(Connection con) {
        this.con = con;
    }
}
