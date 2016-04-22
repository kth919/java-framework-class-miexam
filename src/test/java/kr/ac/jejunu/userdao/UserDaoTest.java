package kr.ac.jejunu.userdao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class UserDaoTest {

   private UserDao userDao;



        @Before
        public void setup(){

        ApplicationContext context = new GenericXmlApplicationContext("DaoFactory.xml");
        userDao = context.getBean("userDao" , UserDao.class);

        }

    @Test
    public void get() throws SQLException, ClassNotFoundException {

//        JejuConnectionMaker jejuConnectionMaker = new JejuConnectionMaker();
//        Connection connection = jejuConnectionMaker.getConnection();


//        UserDao userDao = new DaoFactory().getUserDao();
//
//        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
//        userDao = context.getBean("userDao" , UserDao.class);


        Long id = 1L;
        String name = "김태훈";
        String password = "1234";

        User user = userDao.get(id);

        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));

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

//        UserDao addUser = new DaoFactory().getUserDao();
        UserDao addUser;


        userDao.add(user);

        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));

    }

    @Test
    public void delete() throws SQLException, ClassNotFoundException {

        User user = new User();

        Long id = 1L;
        String name = "김태훈";
        String password = "1234";

        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        userDao.delete(id);
        assertNull(userDao.get(id));
    }


}
