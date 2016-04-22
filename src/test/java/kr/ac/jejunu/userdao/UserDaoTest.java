package kr.ac.jejunu.userdao;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    @Test
    public void get() throws SQLException, ClassNotFoundException {

//        JejuConnectionMaker jejuConnectionMaker = new JejuConnectionMaker();
//        Connection connection = jejuConnectionMaker.getConnection();


        UserDao userDao = new DaoFactory().getUserDao();

        Long id = 1L;
        String name = "김태훈";
        String password = "1234";

        User user = userDao.get(id);

        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        User user = new User();

        Long id = 1L;
        String name = "김태훈";
        String password = "1234";

        user.setId(id);
        user.setName(name);
        user.setPassword(password);

//        JejuConnectionMaker jejuConnectionMaker = new JejuConnectionMaker();
//        Connection connection = jejuConnectionMaker.getConnection();

        UserDao addUser = new DaoFactory().getUserDao();
        addUser.add(user);

        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());

    }
}
