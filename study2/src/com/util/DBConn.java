package com.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConn {
   private static Connection conn = null;

   private DBConn() {

   }

   public static Connection getConnection() {
      
         String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
         String user = "sky";
         String pwd = "java5$";
         
         try {
            if(conn==null){
               Class.forName("oracle.jdbc.driver.OracleDriver");
               conn = DriverManager.getConnection(url, user, pwd);
            
            }
         } catch (Exception e) {
            System.out.println(e.toString());
         }
      return conn;
   }
   
   public static void close() {
      if(conn!=null) {
         try {
            if(!conn.isClosed())
               conn.close();
         } catch (Exception e) {
            
         }
      }
      
      conn = null;
   }
   
}