package kr.ac.jejunu.userdao;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;

public class UserDao {

    private DataSource dataSource;

    public UserDao(){

    }

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }


    public User get(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            //DaoFactory에서 connectionMaker할당
            connection = dataSource.getConnection();

            // 쿼리만들고
            preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
            preparedStatement.setLong(1, id);
            // 실행
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                // 결과매핑
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(resultSet != null)
            //자원을 해지한다.
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(preparedStatement != null)
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

        }


        return user;
    }


    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //데이터는어디에?   Mysql
            //Driver Class Load
            connection = dataSource.getConnection();

            // 쿼리만들고
            preparedStatement = connection.prepareStatement("insert into userinfo (id, name, password) values(?, ? , ?)");

            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPassword());

            // 실행
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
           if(preparedStatement != null)
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
            if(connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

        }

    }

    public void delete(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //데이터는어디에?   Mysql
            //Driver Class Load
            connection = dataSource.getConnection();

            // 쿼리만들고
            preparedStatement = connection.prepareStatement("delete from userinfo where id = ? ");

            preparedStatement.setLong(1, id);

            // 실행
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(preparedStatement != null)
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

        }
    }
}
