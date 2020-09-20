package dao;

import vo.User;

public interface IUserDao {
    int selectOne(User user) throws Exception;
}
