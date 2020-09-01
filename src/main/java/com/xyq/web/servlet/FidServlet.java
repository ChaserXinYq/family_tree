package com.xyq.web.servlet;

import com.xyq.domain.User;
import com.xyq.service.UserService;
import com.xyq.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/fid/*")
public class FidServlet extends BaseServlet {

    UserService service = new UserServiceImpl();

    public void createFid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从session中获取user对象
        User user = (User) req.getSession().getAttribute("user");
        //判断session中user是否为空,是否登录
        if(user != null) {
            //判断user对象中是否存在fid
            if (user.getFid() == null) {
                //调用service创建fid并保存到user中，并且返回这个u
                User u = service.updateFid(user);
                //更新session
                req.getSession().setAttribute("user", u);
                //跳转到getFamilyId.html
                resp.sendRedirect(req.getContextPath()+"/getFamilyTree.html");
            } else {
                resp.sendRedirect(req.getContextPath()+"/queryFamilyId.html");
            }
        } else {
            //用户未登录，跳转到登录页面
            resp.sendRedirect(req.getContextPath()+"/login.html");
        }
    }

    public void findFid(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取session
        User user = (User) req.getSession().getAttribute("user");
        //写回user
        writeValue(user,resp);
    }
}
