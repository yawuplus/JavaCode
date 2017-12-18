package com.ch6;
import com.sun.org.apache.regexp.internal.RE;

import java.sql.*;
public class Conn {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    /*加载驱动程序*/
    public Conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /*执行查询操作*/
    public ResultSet executeQuery(String sql) {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testDB?useUnicode=true&characterEncoding=UTF-8",
                    "root", "root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return rs;
    }

    public int executeUpdate(String sql) {
        int result = 0;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testDB?useUnicode=true&characterEncoding=UTF-8",
                    "root", "root");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            result = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            result = 0;
        }
        return result;
    }

    /*关闭数据库连接*/
    public void close(){
        try {
            if (rs != null) {
                rs.close();
            }
        } catch(Exception e){
                e.printStackTrace(System.err);
            }
        try{
            if(stmt!=null){
                stmt.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            if(conn!=null)
                conn.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
