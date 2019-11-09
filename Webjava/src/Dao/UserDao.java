package Dao;

import User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao{
    User user=null;
    private String url="jdbc:mysql://localhost:3306/userdatabase";
    private String name="root";
    private String password="123456";
    @Override
    public User CheckLoginDao(String uname, String pwd) throws ClassNotFoundException, SQLException {
        String sql="select *from user2 where uname=? and pwd=?";
        Class.forName("com.mysql.jdbc.Driver");  //配置数据库驱动
        Connection conn= DriverManager.getConnection(url,name,password);
        PreparedStatement stat=conn.prepareStatement(sql);
        stat.setString(1,uname);
        stat.setString(2,pwd);
        ResultSet res=stat.executeQuery();  //结果集开始执行
        while(res.next()){   //历遍结果集里的数据
            user=new User();
            user.setUid(res.getInt("uid"));
            user.setUname(res.getString("uname"));
            user.setPwd(res.getString("pwd"));
            user.setAge(res.getInt("age"));
            user.setSex(res.getString("sex"));
            user.setBirth(res.getString("birth"));
        }
        res.close();
        stat.close();
        conn.close();
        return user;
    }

    @Override
    public int CheckUpdateDao(String pwd,int uid) throws ClassNotFoundException, SQLException {
        int user=0;
        Class.forName("com.mysql.jdbc.Driver"); //加载jdbc驱动
        Connection conn=DriverManager.getConnection(url,name,password);
        String sql="Update user2 set pwd=? where uid=?";
        PreparedStatement sta=conn.prepareStatement(sql);
        sta.setString(1,pwd);
        sta.setInt(2,uid);
        user=sta.executeUpdate();
        sta.close();
        conn.close();
        return user;
    }

    @Override
    public List<User> CheckShowUserService() throws ClassNotFoundException, SQLException {
        List<User> show=null;
        String sql="select *from user2";
        Class.forName("com.mysql.jdbc.Driver");  //配置数据库驱动
        Connection conn= DriverManager.getConnection(url,name,password);
        PreparedStatement stat=conn.prepareStatement(sql);
        ResultSet res=stat.executeQuery();  //结果集开始执行
        show=new ArrayList<User>();
        while(res.next()){   //历遍结果集里的数据
            user=new User();
            user.setUid(res.getInt("uid"));
            user.setUname(res.getString("uname"));
            user.setPwd(res.getString("pwd"));
            user.setAge(res.getInt("age"));
            user.setSex(res.getString("sex"));
            user.setBirth(res.getString("birth"));
            show.add(user);
        }
        res.close();
        stat.close();
        conn.close();
        return show;
    }

    @Override
    public User CheckRegisterService(String newname, String newpwd, String sex, String age, String birth) throws ClassNotFoundException, SQLException {
        String sql="insert into user2 values(default,?,?,?,?,?)";
        Class.forName("com.mysql.jdbc.Driver");  //配置数据库驱动
        Connection conn= DriverManager.getConnection(url,name,password);
        PreparedStatement stat=conn.prepareStatement(sql);
        stat.setString(1,newname);
        stat.setString(2,newpwd);
        stat.setString(3,sex);
        stat.setString(4,age);
        stat.setString(5,birth);
        int res=stat.executeUpdate();  //结果集开始执行
        String sql2="select *from user2";
        PreparedStatement stat2=conn.prepareStatement(sql2);
        ResultSet set=stat2.executeQuery();
        while(set.next()){
            user=new User();
            user.setUid(set.getInt("uid"));
            user.setUname(set.getString("uname"));
            user.setPwd(set.getString("pwd"));
            user.setAge(set.getInt("age"));
            user.setSex(set.getString("sex"));
            user.setBirth(set.getString("birth"));
        }
        set.close();
        stat.close();
        conn.close();
        return user;
    }
}
