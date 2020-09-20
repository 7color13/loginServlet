package dao.impl;


import dao.IUserDao;
import vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IUserDaoImpl implements IUserDao {
    private Connection con;
    private PreparedStatement pst;
    public IUserDaoImpl(Connection con){
        this.con=con;
    }
    @Override
    public int selectOne(User user) throws Exception{
        String sql = "select * from t_user where username = ?";
        this.pst = this.con.prepareStatement(sql);
        this.pst.setString(1,user.getUsername());
        ResultSet rs = pst.executeQuery();
        if (rs.next()){
            String password = rs.getString("password");
            if (password.equals(user.getPassword())) {
                return 1;
            }
            return 2;
        }
        return 3;
    }
}
