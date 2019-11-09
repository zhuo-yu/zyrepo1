package Service;

import User.User;

import java.sql.SQLException;
import java.util.List;

public interface Service {
    public User CheckLoginService(String uname,String pwd) throws SQLException, ClassNotFoundException;
    public int CheckUpdateService(String pwd,int uid) throws SQLException, ClassNotFoundException;

    List<User> CheckShowUserService() throws SQLException, ClassNotFoundException;

    User CheckRegisterService(String newname, String newpwd, String sex, String age, String birth) throws SQLException, ClassNotFoundException;
}
