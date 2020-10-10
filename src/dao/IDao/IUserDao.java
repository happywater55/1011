package dao.IDao;

import vo.User;

public interface IUserDao {
    public User getByUsername(String string) throws Exception;

    public boolean addUser(User user) throws  Exception;

    public boolean update(User user) throws Exception;

    public boolean delete(User user) throws Exception;

}
