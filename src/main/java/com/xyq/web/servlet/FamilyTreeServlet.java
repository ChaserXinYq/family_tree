package com.xyq.web.servlet;

import com.xyq.domain.Detail;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/familyTree/*")
public class FamilyTreeServlet extends BaseServlet {

    /**
     * 查询到所有具有相同fid的用户返回list集合
     * @param request
     * @param response
     */
    public void showFamilyTree(HttpServletRequest request, HttpServletResponse response){

        Detail detail1 = new Detail("8859",1,"张三","男","img/logo.png","你好啊","123");
        Detail detail2 = new Detail("8859",2,"李四","男","img/logo.png","你好啊","124");
        Detail detail3 = new Detail("8859",3,"王五","男","img/logo.png","你好啊","125");
        Detail detail4 = new Detail("8859",4,"赵柳","男","img/logo.png","你好啊","126");
        Detail detail5 = new Detail("8859",5,"钱七","男","img/logo.png","你好啊","127");
        Detail detail6 = new Detail("8859",6,"张八","男","img/logo.png","你好啊","128");
        Detail detail7 = new Detail("8859",7,"宋九","男","img/logo.png","你好啊","129");
        Detail detail8 = new Detail("8859",8,"唐十","男","img/logo.png","你好啊","130");
        Detail detail9 = new Detail("8859",9,"高十一","男","img/logo.png","你好啊","131");

        List<Detail> list = new ArrayList<>();
        list.add(detail1);
        list.add(detail2);
        list.add(detail3);
        list.add(detail4);
        list.add(detail5);
        list.add(detail6);
        list.add(detail7);
        list.add(detail8);
        list.add(detail9);

        writeValue(list,response);
    }
}
