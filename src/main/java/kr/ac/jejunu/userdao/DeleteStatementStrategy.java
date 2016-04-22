//package kr.ac.jejunu.userdao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
///**
// * Created by admin on 2016-04-22.
// */
//public class DeleteStatementStrategy extends StatementStrategy {
//
//    private Long id;
//    PreparedStatement preparedStatement;
//
//
//    public DeleteStatementStrategy(Long id){
//        this.id = id;
//    }
//
//    @Override
//    public PreparedStatement makeStatement(Connection connection) throws SQLException {
//
//        preparedStatement = connection.prepareStatement("delete from userinfo where id = ? ");
//        preparedStatement.setLong(1, id);
//        return preparedStatement;
//    }
//}
