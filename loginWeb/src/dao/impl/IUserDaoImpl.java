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
    public User selectOne(User user) throws Exception{
        User user1 =new User() ;
        String sql = "select * from t_user where username = ?";
        this.pst = this.con.prepareStatement(sql);
        this.pst.setString(1,user.getUsername());
        ResultSet rs = pst.executeQuery();
        if (rs.next()){
            String password = rs.getString("password");
            if (password.equals(user.getPassword())) {
                user1 = new User(rs.getString("username"), rs.getString("password"), rs.getString("chrName"), rs.getString("role"));
            }
            else {
                user1.setUsername(user.getUsername());
            }
        }
       return user1;
    }
}
