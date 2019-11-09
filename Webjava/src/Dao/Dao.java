package Dao;

import User.User;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
    public User CheckLoginDao(String uname,String pwd) throws ClassNotFoundException, SQLException;
    public int CheckUpdateDao(String pwd,int uid) throws ClassNotFoundException, SQLException;

    List<User> CheckShowUserService() throws ClassNotFoundException, SQLException;

    User CheckRegisterService(String newname, String newpwd, String sex, String age, String birth) throws ClassNotFoundException, SQLException;
}
