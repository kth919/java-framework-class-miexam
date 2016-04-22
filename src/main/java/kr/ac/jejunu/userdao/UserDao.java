package kr.ac.jejunu.userdao;

import java.sql.*;

public  class UserDao {

    public JdbcContext jdbcContext;

    public void setJdbcContext(JdbcContext jdbcContext){
        this.jdbcContext = jdbcContext;

    }

    public UserDao(){

    }

    public User get(final Long id) throws ClassNotFoundException, SQLException {

        StatementStrategy statementStrategy = new GetUserStatementStrategy(id);
        return jdbcContext.jdbcContextWithStatementStrategyForQuery(new StatementStrategy() {
            @Override
            public PreparedStatement makeStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement;
                preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
                preparedStatement.setLong(1, id);
                return preparedStatement;
            }
        });
    }


    public void add(final User user) throws ClassNotFoundException, SQLException {
        jdbcContext.jdbcContextStatementStrategyForUpdate(new StatementStrategy() {

            @Override
            public PreparedStatement makeStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement;

                preparedStatement = connection.prepareStatement("insert into userinfo (id, name, password) values(?, ? , ?)");
                preparedStatement.setLong(1, user.getId());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getPassword());
                return preparedStatement;
            }
        });
    }

    public void delete(final Long id) throws SQLException {
        jdbcContext.jdbcContextStatementStrategyForUpdate(new StatementStrategy() {

            @Override
            public PreparedStatement makeStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement;
                preparedStatement = connection.prepareStatement("delete from userinfo where id = ? ");
                preparedStatement.setLong(1, id);
                return preparedStatement;
            }
        });
    }


}
