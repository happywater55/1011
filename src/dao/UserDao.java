package dao;

import dao.IDao.IUserDao;
import vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao implements IUserDao {
    private Connection connection;
//    连接对象
    private PreparedStatement preparedStatement;

    public UserDao(Connection connection) {
        this.connection = connection;

    }

    @Override
    public User getByUsername(String userName) throws Exception {
        String sql = "SELECT * from t_user where username = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1,userName);
        ResultSet resultSet = this.preparedStatement.executeQuery();

        User user = new User();
        if(resultSet.next()){

            user.setUserName(resultSet.getString("userName"));
            user.setChrName(resultSet.getString("chrName"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));

        }

        else {
            user = null;
        }
//        resultSet.close();
//        this.preparedStatement.close();
//        this.connection.close();
        return user;
    }

    @Override
    public boolean addUser(User user) throws Exception {
        return false;
    }

    @Override
    public boolean update(User user) throws Exception {
        return false;
    }

    @Override
    public boolean delete(User user) throws Exception {
        return false;
    }
}
