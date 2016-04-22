package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by admin on 2016-04-22.
 */
public abstract class StatementStrategy {

    public abstract PreparedStatement makeStatement(Object object, Connection connection) throws SQLException;

}
