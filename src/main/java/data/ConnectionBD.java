package data;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource; 

public class ConnectionBD {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3308/control"; 
    private static final String JDBC_USER = "root"; 
    private static final String JDBC_PASSWORD = ""; 
    private static BasicDataSource dataSource; 
    
    public static DataSource getDataSource() throws ClassNotFoundException{
        if(dataSource == null){
        dataSource = new BasicDataSource();
        Class.forName("com.mysql.jdbc.Driver");
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(JDBC_USER);
        dataSource.setPassword(JDBC_PASSWORD);
        dataSource.setInitialSize(50);
        }
        return dataSource; 
    }
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        return getDataSource().getConnection(); 
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
