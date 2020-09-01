package com.xyq.web.servlet;

import com.xyq.domain.Detail;
import com.xyq.domain.ResultInfo;
import com.xyq.domain.User;
import com.xyq.service.DetailService;
import com.xyq.service.impl.DetailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/detail/*")
public class DetailServlet extends BaseServlet {
    private DetailService service = new DetailServiceImpl();

    public void saveMessage(HttpServletRequest request, HttpServletResponse response) {
        //获取前端传过来的值
        String headImgUrl = request.getParameter("headImg");

        //判断为空就不能转

        String nodeNumber = request.getParameter("nodeId");
        Integer nodeId;
        if (nodeNumber == null || nodeNumber.length() <= 0 || "null".equals(nodeNumber)) {
            nodeId = 0;
        } else {
            nodeId = Integer.parseInt(nodeNumber);
        }

        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String message = request.getParameter("message");
        User user = (User) request.getSession().getAttribute("user");
        String fid = user.getFid();

        //将数据封装成detail对象
        Detail detail = new Detail();
        detail.setFid(fid);
        detail.setNodeId(nodeId);
        detail.setName(name);
        detail.setSex(sex);
        detail.setHeadImgUrl(headImgUrl);
        detail.setDetails(message);
        detail.setPhone(phone);

//        System.out.println(detail);
        //判断这个fid的nodeId的信息是否已经存在
        Detail dt = service.findDetail(fid, nodeId);
        if (dt == null) {
            //调用service将detail存入数据库中
            service.saveDetail(detail);
        } else {
            //此nodeId已经存在，更新数据
            service.updateDetail(detail);
        }

        //通过fid和nodeId查询是否存在


    }

    /**
     * 修缮家谱判断是否登录和是否已经创建过家谱
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void ifLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            //已经登录
            //判断是否已经创建过家谱
            if (user.getFid() != null && user.getFid().length() > 0 && !"null".equals(user.getFid())) {
                //已经创建过家谱了，跳转到修缮家谱页面
                resp.sendRedirect(req.getContextPath() + "/CreateFamilyTree.html");
            } else {
                //尚未创建家谱
                resp.sendRedirect(req.getContextPath() + "/ErrorMsg.html");
            }
        } else {
            //没有登陆
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }
    }

    /**
     * 通过登陆人的fid查询详细信息表获取该fid所有信息
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void findAllDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        List<Detail> list = service.findAllDetail(user.getFid());
        writeValue(list, resp);


    }

    public void findAllByFid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fid = req.getParameter("fid");
        List<Detail> list = service.findAllDetail(fid);
        ResultInfo info = new ResultInfo();
        if (list==null||list.size()<=0||"null".equals(list)){
            //查不到
            info.setFlag(false);
            info.setErrorMsg("您输入的familyId有误");
        }else {
            info.setFlag(true);
        }
//        System.out.println(info);


        writeValue(info, resp);
    }

    public void findAllByInputFid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fid = req.getParameter("fid");
        List<Detail> list = service.findAllDetail(fid);
        writeValue(list, resp);
    }

}
