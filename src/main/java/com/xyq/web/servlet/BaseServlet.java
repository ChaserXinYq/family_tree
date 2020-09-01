package com.xyq.web.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 该类的作用：通过访问路径执行servlet中的不同方法
 */
public class BaseServlet extends HttpServlet {

    public void service(HttpServletRequest request , HttpServletResponse response){
        //获取请求路径
        String uri = request.getRequestURI();
        //获取请求路径下的方法名称
        String methodName = uri.substring(uri.lastIndexOf('/') + 1);
//       System.out.println("方法名"+methodName);
        //谁调用该方法，谁就是this
//       System.out.println("this对象"+this);
        //获取方法的对象
        try {
            //获取方法对象
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //执行方法
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 直接将传入的对象进行序列化
     * @param obj
     * @param response
     */
    public void writeValue(Object obj,HttpServletResponse response){
        try {
            //将数据序列化为json
            ObjectMapper mapper = new ObjectMapper();
//           String json = mapper.writeValueAsString(obj);
            //将json数据返回给客户端
            response.setContentType("application/json;utf-8");
//           response.getWriter().write(json);
            mapper.writeValue(response.getOutputStream(),obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

