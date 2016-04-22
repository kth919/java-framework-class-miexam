package kr.ac.jejunu.userdao;

import javax.swing.tree.RowMapper;
import java.sql.*;

public  class UserDao {

    public JdbcContext jdbcTemplate;



    public UserDao(){

    }
    
    public User get(final String id) throws SQLException{
        return getJdbcTemplate().queryForObject(sql, args, new RowMapper<User>());
    }

    public User get(final Long id) throws ClassNotFoundException, SQLException {

//        StatementStrategy statementStrategy = new GetUserStatementStrategy(id);
        return jdbcTemplate.jdbcContextWithStatementStrategyForQuery(new StatementStrategy() {
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

            final String query = "insert into userinfo (id, name, password) values(?, ? , ?)";
            final String[] params = new String[]{String.valueOf(user.getId()), user.getName(), user.getPassword()};

        jdbcTemplate.update(query, params);

    }

    public void delete(final Long id) throws SQLException {

        final String query = "delete from userinfo where id = ? ";
        final String[] params = new String[]{String.valueOf(id)};

        jdbcTemplate.update(query, params);
    }


    public JdbcContext getJdbcTemplate() {
        return jdbcTemplate;
    }
}
