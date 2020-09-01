package com.xyq.web.servlet;

import com.xyq.domain.ResultInfo;
import com.xyq.domain.User;
import com.xyq.service.UserService;
import com.xyq.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    public void addUserServlet(HttpServletRequest request, HttpServletResponse response){
        UserService userService = new UserServiceImpl();

        //获取去前端传过来的参数
        Map<String, String[]> map = request.getParameterMap();
        //将获取的值封装为user对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //将user存入数据库
        Boolean flag = userService.addUser(user);

        //判断是否存入成功
        ResultInfo info = new ResultInfo();
        if (flag==true){
            //存入成功
            info.setFlag(true);
        }else {
            //存入失败
            info.setFlag(false);
            info.setErrorMsg("该用户已存在");
        }

        //将数据转换为json数据,发送回前端
        writeValue(info,response);

    }

    public void LoginServlet(HttpServletRequest request,HttpServletResponse response){
        UserService userService = new UserServiceImpl();
        //获取前端传过来的值,封装成user对象
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        User byUser = userService.findByUser(user);
        ResultInfo info = new ResultInfo();
        //根据user对象查询用户是否存在，存在返回true
        if (byUser!=null){
            //将用户信息存到session中，并返回true
            info.setFlag(true);
            request.getSession().setAttribute("user",byUser);
        }else {
            //不存在，返回false和错误信息
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误！");

        }
        //将info对象返回前端
        writeValue(info,response);
    }

    /**
     * 退出方法
     * @param request
     * @param response
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //销毁session
        request.getSession().invalidate();
        //跳转页面
        response.sendRedirect(request.getContextPath()+"/login.html");
    }
}
