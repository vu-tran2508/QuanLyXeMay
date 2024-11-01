/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.helper;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author pdo18
 */
public class JdbcHelper {
     static String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String dburl ="jdbc:sqlserver://localhost:1433;database=DUANB12";
    static String username = "sa";
    static String password = "123456";
   
    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static PreparedStatement getStmt(String sql, Object...args) throws SQLException{
        Connection conn = DriverManager.getConnection(dburl,username, password);
        PreparedStatement stmt;
        if (sql.trim().startsWith("{")) {
            stmt = conn.prepareCall(sql);
            
        }else {
            stmt =conn.prepareStatement(sql);
        }
        for(int i=0; i<args.length; i++){
            stmt.setObject(i+1,args[i]);
        }
        return stmt;
        
    }
    public static ResultSet query(String sql , Object...args) throws SQLException{
        PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
        return  stmt.executeQuery();
        
    }
    public static Object value(String sql , Object...args){
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static int update(String sql, Object ...args){
        try {
            PreparedStatement stmt =JdbcHelper.getStmt(sql, args);
            try {
                return  stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
            
            
            
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
    }
}
