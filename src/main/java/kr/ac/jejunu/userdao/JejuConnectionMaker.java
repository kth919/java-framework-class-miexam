package kr.ac.jejunu.userdao;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.activation.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
//import java.sql.SQLException;
//
///**
// * Created by admin on 2016-04-22.
// */
//public class JejuConnectionMaker extends SimpleDriverDataSource {
//
//    public JejuConnectionMaker(){
//        this.setDriverClass(Driver.class);
//        this.setUrl("jdbc:mysql://localhost/userinfo?characterEncoding=utf-8");
//        this.setUsername("root");
//        this.setPassword("1234");
//    }
////
////    @Override
////    public Connection getConnection() throws ClassNotFoundException, SQLException {
////
////        Class.forName("com.mysql.jdbc.Driver");
////       return DriverManager.getConnection("jdbc:mysql://localhost/userinfo", "root", "1234");
////
////    }
//}
