package kr.ac.jejunu.userdao;

import java.sql.SQLException;

/**
 * Created by admin on 2016-04-22.
 */
public class DaoFactory {

    public UserDao getUserDao() throws SQLException, ClassNotFoundException {
        ConnectionMaker connection = new JejuConnectionMaker();
        UserDao userDao = new UserDao(connection);
        return userDao;
    }
//    ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
//    userDao = context.getBean("userDao" , UserDao.class);

    }
