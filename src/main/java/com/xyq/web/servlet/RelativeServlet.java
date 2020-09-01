package com.xyq.web.servlet;

import com.xyq.domain.Detail;
import com.xyq.domain.Node;
import com.xyq.domain.User;
import com.xyq.service.DetailService;
import com.xyq.service.RelativeService;
import com.xyq.service.impl.DetailServiceImpl;
import com.xyq.service.impl.RelativeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/relative/*")
public class RelativeServlet extends BaseServlet {

    RelativeService relativeService = new RelativeServiceImpl();
    DetailService detailService = new DetailServiceImpl();

    /**
     * 根据登录人的fid和phone在detail表中查找NodeId
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void finNodeId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在session中获取用户
        User user = (User) req.getSession().getAttribute("user");
        String fid = user.getFid();
        String phone = user.getPhone();
        Detail detail = relativeService.findNodeId(fid, phone);
        //创建要写回的实体类Node
        Node node = new Node();
        //初始化node
        node.setNode1(null);
        node.setNode2(null);
        node.setNode3(null);
        node.setNode4(null);
        node.setNode5(null);
        node.setNode6(null);
        node.setNode7(null);
        node.setNode8(null);
        node.setNode9(null);
        //判断登入者是否已经保存过自己的详细信息
        if (detail != null) {
            //已经有保存过，即有对应的nodeId
            if (detail.getNodeId() == 3 || detail.getNodeId() == 4
                    || detail.getNodeId() == 5 || detail.getNodeId() == 6) {
                //3,4,5,6node需要昵称的只有1,2
                //根据fid和nodeId=1获取nodeId的信息
                Detail detail1 = detailService.findDetail(fid, 1);
                //判断detail1的信息是否存在
                if (detail1 != null) {
                    //存在,获取detail1的性别
                    String sex = detail1.getSex();
                    if (sex != null) {
                        if (sex.equals("男")) {
                            node.setNode1("爸爸");
                        }
                        if (sex.equals("女")) {
                            node.setNode1("妈妈");
                        }
                    }
                }
                //3,4,5,6node需要昵称的只有1,2
                //根据fid和nodeId=2获取nodeId的信息
                Detail detail2 = detailService.findDetail(fid, 2);
                //判断detail1的信息是否存在
                if (detail2 != null) {
                    //存在,获取detail1的性别
                    String sex = detail2.getSex();
                    if (sex != null) {
                        if (sex.equals("男")) {
                            node.setNode2("父亲");
                        }
                        if (sex.equals("女")) {
                            node.setNode2("母亲");
                        }
                    }
                }
            }

            if (detail.getNodeId() == 7 || detail.getNodeId() == 8) {
                //7,8node需要昵称的有：1,2,3,4,5,6
                //7,8node对应的1,2昵称需要根据3,4来判断
                Detail detail4 = detailService.findDetail(fid, 4);
                //判断detail4的信息是否存在
                if (detail4 != null) {
                    //存在，获取detail4的性别
                    String sex = detail4.getSex();
                    //判断sex是否存在
                    if (sex != null) {
                        if (sex.equals("男")) {
                            node.setNode4("爸爸");
                            //确定性别后，根据性别判断1,2的昵称
                            Detail detail1 = detailService.findDetail(fid, 1);
                            //判断detail1的信息是否存在
                            if (detail1 != null) {
                                //存在,获取detail1的性别
                                String s = detail1.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode1("爷爷");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode1("奶奶");
                                    }
                                }
                            }
                            Detail detail2 = detailService.findDetail(fid, 2);
                            //判断detail1的信息是否存在
                            if (detail2 != null) {
                                //存在,获取detail1的性别
                                String s = detail2.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode2("爷爷");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode2("奶奶");
                                    }
                                }
                            }
                        }
                        if (sex.equals("女")) {
                            node.setNode4("妈妈");
                            //确定性别后，根据性别判断1,2的昵称
                            Detail detail1 = detailService.findDetail(fid, 1);
                            //判断detail1的信息是否存在
                            if (detail1 != null) {
                                //存在,获取detail1的性别
                                String s = detail1.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode1("外公");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode1("外婆");
                                    }
                                }
                            }
                            Detail detail2 = detailService.findDetail(fid, 2);
                            //判断detail1的信息是否存在
                            if (detail2 != null) {
                                //存在,获取detail1的性别
                                String s = detail2.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode2("外公");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode2("外婆");
                                    }
                                }
                            }
                        }
                    }
                }
                Detail detail3 = detailService.findDetail(fid, 3);
                //判断detail3的信息是否存在
                if (detail3 != null) {
                    //存在，获取detail3的性别
                    String sex = detail3.getSex();
                    //判断sex是否存在
                    if (sex != null) {
                        if (sex.equals("男")) {
                            node.setNode3("爸爸");
                            //确定性别后，根据性别判断1,2的昵称
                            Detail detail1 = detailService.findDetail(fid, 1);
                            //判断detail1的信息是否存在
                            if (detail1 != null) {
                                //存在,获取detail1的性别
                                String s = detail1.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode1("爷爷");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode1("奶奶");
                                    }
                                }
                            }
                            Detail detail2 = detailService.findDetail(fid, 2);
                            //判断detail2的信息是否存在
                            if (detail2 != null) {
                                //存在,获取detail2的性别
                                String s = detail2.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode2("爷爷");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode2("奶奶");
                                    }
                                }
                            }
                        }
                        if (sex.equals("女")) {
                            node.setNode3("妈妈");
                            //确定性别后，根据性别判断1,2的昵称
                            Detail detail1 = detailService.findDetail(fid, 1);
                            //判断detail1的信息是否存在
                            if (detail1 != null) {
                                //存在,获取detail1的性别
                                String s = detail1.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode1("外公");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode1("外婆");
                                    }
                                }
                            }
                            Detail detail2 = detailService.findDetail(fid, 2);
                            //判断detail1的信息是否存在
                            if (detail2 != null) {
                                //存在,获取detail1的性别
                                String s = detail2.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode2("外公");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode2("外婆");
                                    }
                                }
                            }
                        }
                    }
                }
                Detail detail5 = detailService.findDetail(fid, 5);
                if(detail5 != null) {
                    String sex = detail5.getSex();
                    if(sex != null) {
                        if(sex.equals("男")) {
                            node.setNode5("叔叔");
                        }
                        if(sex.equals("女")) {
                            node.setNode5("阿姨");
                        }
                    }
                }
                Detail detail6 = detailService.findDetail(fid, 6);
                if(detail6 != null) {
                    String sex = detail6.getSex();
                    if(sex != null) {
                        if(sex.equals("男")) {
                            node.setNode6("叔叔");
                        }
                        if(sex.equals("女")) {
                            node.setNode6("阿姨");
                        }
                    }
                }
            }
            if (detail.getNodeId() == 9) {
                //9,node需要昵称的有：1,2,3,4,5,6
                //9,node对应的1,2昵称需要根据5,6来判断
                Detail detail5 = detailService.findDetail(fid, 5);
                //判断detail4的信息是否存在
                if (detail5 != null) {
                    //存在，获取detail4的性别
                    String sex = detail5.getSex();
                    //判断sex是否存在
                    if (sex != null) {
                        if (sex.equals("男")) {
                            node.setNode5("爸爸");
                            //确定性别后，根据性别判断1,2的昵称
                            Detail detail1 = detailService.findDetail(fid, 1);
                            //判断detail1的信息是否存在
                            if (detail1 != null) {
                                //存在,获取detail1的性别
                                String s = detail1.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode1("爷爷");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode1("奶奶");
                                    }
                                }
                            }
                            Detail detail2 = detailService.findDetail(fid, 2);
                            //判断detail1的信息是否存在
                            if (detail2 != null) {
                                //存在,获取detail1的性别
                                String s = detail2.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode2("爷爷");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode2("奶奶");
                                    }
                                }
                            }
                        }
                        if (sex.equals("女")) {
                            node.setNode5("妈妈");
                            //确定性别后，根据性别判断1,2的昵称
                            Detail detail1 = detailService.findDetail(fid, 1);
                            //判断detail1的信息是否存在
                            if (detail1 != null) {
                                //存在,获取detail1的性别
                                String s = detail1.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode1("外公");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode1("外婆");
                                    }
                                }
                            }
                            Detail detail2 = detailService.findDetail(fid, 2);
                            //判断detail1的信息是否存在
                            if (detail2 != null) {
                                //存在,获取detail1的性别
                                String s = detail2.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode2("外公");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode2("外婆");
                                    }
                                }
                            }
                        }
                    }
                }
                Detail detail6 = detailService.findDetail(fid, 6);
                //判断detail4的信息是否存在
                if (detail6 != null) {
                    //存在，获取detail4的性别
                    String sex = detail6.getSex();
                    //判断sex是否存在
                    if (sex != null) {
                        if (sex.equals("男")) {
                            node.setNode6("爸爸");
                            //确定性别后，根据性别判断1,2的昵称
                            Detail detail1 = detailService.findDetail(fid, 1);
                            //判断detail1的信息是否存在
                            if (detail1 != null) {
                                //存在,获取detail1的性别
                                String s = detail1.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode1("爷爷");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode1("奶奶");
                                    }
                                }
                            }
                            Detail detail2 = detailService.findDetail(fid, 2);
                            //判断detail1的信息是否存在
                            if (detail2 != null) {
                                //存在,获取detail1的性别
                                String s = detail2.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode2("爷爷");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode2("奶奶");
                                    }
                                }
                            }
                        }
                        if (sex.equals("女")) {
                            node.setNode6("妈妈");
                            //确定性别后，根据性别判断1,2的昵称
                            Detail detail1 = detailService.findDetail(fid, 1);
                            //判断detail1的信息是否存在
                            if (detail1 != null) {
                                //存在,获取detail1的性别
                                String s = detail1.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode1("外公");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode1("外婆");
                                    }
                                }
                            }
                            Detail detail2 = detailService.findDetail(fid, 2);
                            //判断detail1的信息是否存在
                            if (detail2 != null) {
                                //存在,获取detail1的性别
                                String s = detail2.getSex();
                                if (s != null) {
                                    if (s.equals("男")) {
                                        node.setNode2("外公");
                                    }
                                    if (s.equals("女")) {
                                        node.setNode2("外婆");
                                    }
                                }
                            }
                        }
                    }
                }
                Detail detail3 = detailService.findDetail(fid, 3);
                if(detail3 != null) {
                    String sex = detail3.getSex();
                    if(sex != null) {
                        if(sex.equals("男")) {
                            node.setNode3("叔叔");
                        }
                        if(sex.equals("女")) {
                            node.setNode3("阿姨");
                        }
                    }
                }
                Detail detail4 = detailService.findDetail(fid, 4);
                if(detail4 != null) {
                    String sex = detail4.getSex();
                    if(sex != null) {
                        if(sex.equals("男")) {
                            node.setNode4("叔叔");
                        }
                        if(sex.equals("女")) {
                            node.setNode4("阿姨");
                        }
                    }
                }
            }
        }
        //最后写回node
        writeValue(node, resp);
    }
}
