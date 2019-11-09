package Service;

import Dao.Dao;
import Dao.UserDao;
import User.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements Service{
    Dao userdao=new UserDao();

//处理登录信息
    @Override
    public User CheckLoginService(String uname,String pwd) throws SQLException, ClassNotFoundException {
        return userdao.CheckLoginDao(uname,pwd);
    }
//处理修改密码
    @Override
    public int CheckUpdateService(String pwd,int uid) throws SQLException, ClassNotFoundException {
        return userdao.CheckUpdateDao(pwd,uid);
    }
//处理显示用户信息
    @Override
    public List<User> CheckShowUserService() throws SQLException, ClassNotFoundException {
        return userdao.CheckShowUserService();
    }
//处理注册
    @Override
    public User CheckRegisterService(String newname, String newpwd, String sex, String age, String birth) throws SQLException, ClassNotFoundException {
        return userdao.CheckRegisterService(newname,newpwd,sex,age,birth);
    }
}
