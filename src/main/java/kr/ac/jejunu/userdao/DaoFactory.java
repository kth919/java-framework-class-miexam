package kr.ac.jejunu.userdao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * Created by admin on 2016-04-22.
 */
public class DaoFactory {

    @Bean
    public UserDao getUserDao() throws SQLException, ClassNotFoundException {
        ConnectionMaker connection = new JejuConnectionMaker();
        UserDao userDao = new UserDao(connection);
        return userDao;
    }

    }
