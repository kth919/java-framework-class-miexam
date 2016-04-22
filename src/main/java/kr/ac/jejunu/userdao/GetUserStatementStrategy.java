package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by admin on 2016-04-22.
 */
public class GetUserStatementStrategy extends StatementStrategy {

        PreparedStatement preparedStatement;

    @Override
    public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setLong(1, (Long)object);
        return preparedStatement;    }


}
