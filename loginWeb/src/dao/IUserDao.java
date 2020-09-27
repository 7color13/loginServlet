package dao;

import vo.User;

public interface IUserDao {
    User selectOne(User user) throws Exception;
}
