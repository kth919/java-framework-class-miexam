package kr.ac.jejunu.userdao;

import org.springframework.jdbc.datasource.ConnectionProxy;

import java.sql.*;

public class UserDao {

    ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
            this.connectionMaker = connectionMaker;
    }

    public UserDao() {

    }


    public User get(Long id) throws ClassNotFoundException, SQLException {

        //DaoFactory에서 connectionMaker할당
        Connection connection = connectionMaker.getConnection();

        // 쿼리만들고
        PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setLong(1, id);
        // 실행
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        // 결과매핑
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        //자원을 해지한다.
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }


    public void add(User user) throws ClassNotFoundException, SQLException {
        //데이터는어디에?   Mysql
        //Driver Class Load
        Connection connection = connectionMaker.getConnection();

        // 쿼리만들고
        PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo (id, name, password) values(?, ? , ?)");

        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());

        // 실행
        preparedStatement.executeUpdate();
        // 결과매핑
        //자원을 해지한다.
        preparedStatement.close();
        connection.close();

    }

    public void setConnectionMaker(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }

}
