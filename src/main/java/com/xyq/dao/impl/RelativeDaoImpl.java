package com.xyq.dao.impl;

import com.xyq.dao.RelativeDao;
import com.xyq.domain.Detail;
import com.xyq.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class RelativeDaoImpl implements RelativeDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Detail findNodeId(String fid, String phone) {
        Detail detail = null;
        try {
            String sql = "select * from detail where fid = ? and  phone = ?";
            detail = template.queryForObject(sql,new BeanPropertyRowMapper<Detail>(Detail.class),fid,phone);
        } catch (Exception e) {

        }
        return detail;
    }
}
