package Servlet;

import Service.UserService;
import Service.Service;
import User.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String submit=req.getParameter("submit");
        if(submit.equals("login")){
            checkLoginservice(req,resp); //调用登录处理方法
        }else if(submit.equals("register")){
            try {
                checkRegisterservice(req,resp); //调用注册处理方法
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if(submit.equals("out")){
            checkOutservice(req,resp);  //调用退出功能
        }else if(submit.equals("update")){
            try {
                changeUpdateservice(req,resp);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }else if(submit.equals("show")){
            try {
                checkShowUserService(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("没有找到对应的操作符"+submit);
        }

    }
    /*
    * 处理查看用户信息功能
    * */
    private void checkShowUserService(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String show=req.getParameter("show");
        Service Showuser=new UserService();
        List<User> user=Showuser.CheckShowUserService();
        req.setAttribute("showuser",user);
        req.getRequestDispatcher("/ShowUser/ShowUser.jsp").forward(req,resp);
        return;
    }
    /*
    * 处理修改密码功能
    * */
    private void changeUpdateservice(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
               String password=req.getParameter("newpwd");
               HttpSession hs=req.getSession();  //创建Session来获取Uid
               int uid=((User)hs.getAttribute("user")).getUid();
               Service UserUpdate=new UserService();
           //    hs.setAttribute("conform","消息");
               int user=UserUpdate.CheckUpdateService(password,uid);
               if(user>0){
                   hs.setAttribute("pwd","修改密码成功,请重新登录");
                   resp.sendRedirect("/Web_Manager_war_exploded/Login.jsp");
                   return;
               }

    }
    /*
    * 处理退出功能
    * */
    private void checkOutservice(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session=req.getSession();
        session.invalidate();  //强制销毁session
        resp.sendRedirect("Login.jsp");
    }
    /*
        处理注册功能
     */
    private void checkRegisterservice(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ClassNotFoundException {
            String newname=req.getParameter("newname");
            String newpwd=req.getParameter("newpwd");
            String sex=req.getParameter("sex");
            String age=req.getParameter("age");
            String birth=req.getParameter("birth");
            Service register=new UserService();
            User user=register.CheckRegisterService(newname,newpwd,sex,age,birth);
        System.out.println(newname);
        System.out.println(user.getUname());
            if(user.getUname().equals(newname)){
                HttpSession session=req.getSession();
                session.setAttribute("register","注册成功");
                resp.sendRedirect("/Web_Manager_war_exploded/Login.jsp");
                return;
            }
    }
/*
    处理登录功能
 */
    private void checkLoginservice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String uname=req.getParameter("uname");
        String pwd=req.getParameter("pwd");
        Service UserLogin=new UserService();
        try {
            User user=UserLogin.CheckLoginService(uname,pwd);
            System.out.println(user);
            if(user!=null){
                HttpSession session=req.getSession();
                session.setAttribute("user",user);
                resp.sendRedirect("Main/main.jsp");
                return;
            }else{
                HttpSession session=req.getSession();  //创建Session对象给登录界面传递信息
                session.setAttribute("fail","您的用户名或密码错误，请重新输入");
                resp.sendRedirect("Login.jsp");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
