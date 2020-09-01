package com.xyq.dao.impl;

import com.xyq.dao.DetailDao;
import com.xyq.domain.Detail;
import com.xyq.domain.User;
import com.xyq.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DetailDaoImpl implements DetailDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Detail> findAllDetail(String fid) {
        List<Detail> list = null;
        try {
            //定义sql
            String sql = "select * from detail where fid = ? order by nodeId asc ";
            list = template.query(sql, new BeanPropertyRowMapper<Detail>(Detail.class), fid);
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public void saveDetail(Detail detail) {
        String sql = "insert into detail(fid,nodeId,name,sex,headImgUrl,details,phone) values(?,?,?,?,?,?,?)";
        template.update(sql,detail.getFid(),
                detail.getNodeId(),
                detail.getName(),
                detail.getSex(),
                detail.getHeadImgUrl(),
                detail.getDetails(),
                detail.getPhone());
    }

    @Override
    public boolean findFid(String fid) {
            String sql = "select * from user where fid = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), fid);
            if(user == null) {
                //用户不存在，说明fid不存在
                return false;
            }else {
                //用户存在
                return true;
            }
    }

    @Override
    public Detail findDetail(String fid, Integer nodeId) {
        Detail dt = null;
        try {
            String sql = "select * from detail where fid = ? and nodeId = ?";
            dt = template.queryForObject(sql,new BeanPropertyRowMapper<Detail>(Detail.class),fid,nodeId);
        } catch (DataAccessException e) {

        }
        return dt;
    }

    /**
     * 更新详细信息的数据
     * @param detail
     */
    @Override
    public void updateDetail(Detail detail) {
        String sql = "update detail set name = ?, sex = ?, " +
                "headImgUrl = ?, details = ?, phone = ? where nodeId = ? and  fid = ?";
        template.update(sql,
                detail.getName(),
                detail.getSex(),
                detail.getHeadImgUrl(),
                detail.getDetails(),
                detail.getPhone(),
                detail.getNodeId(),
                detail.getFid());
    }
}
