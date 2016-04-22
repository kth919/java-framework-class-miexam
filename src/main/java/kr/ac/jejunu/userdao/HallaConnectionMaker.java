//package kr.ac.jejunu.userdao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
///**
// * Created by admin on 2016-04-22.
// */
//public class HallaConnectionMaker implements ConnectionMaker {
//    @Override
//    public Connection getConnection() throws ClassNotFoundException, SQLException {
//
//        Class.forName("com.mysql.jdbc.Driver");
//        return DriverManager.getConnection("jdbc:mysql://localhost/userinfo", "root", "1234");
//
//    }
//}
