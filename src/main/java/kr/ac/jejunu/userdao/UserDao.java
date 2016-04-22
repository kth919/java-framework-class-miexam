package kr.ac.jejunu.userdao;

import java.sql.*;

public  class UserDao {

    public JdbcContext jdbcContext;

    public void setJdbcContext(JdbcContext jdbcContext){
        this.jdbcContext = jdbcContext;

    }

    public UserDao(){

    }

    public User get(Long id) throws ClassNotFoundException, SQLException {

        StatementStrategy statementStrategy = new GetUserStatementStrategy(id);
        return jdbcContext.jdbcContextWithStatementStrategyForQuery(statementStrategy);
    }


    public void add(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new AddUserStatementStrategy(user);
        jdbcContext.jdbcContextStatementStrategyForUpdate(statementStrategy);


    }

    public void delete(Long id) throws SQLException {
        StatementStrategy statementStrategy = new DeleteStatementStrategy(id);
        jdbcContext.jdbcContextStatementStrategyForUpdate(statementStrategy);
    }


}
