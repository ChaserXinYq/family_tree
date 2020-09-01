package com.xyq.dao.impl;

import com.xyq.dao.UserDao;
import com.xyq.domain.User;
import com.xyq.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByPhoneAndPassword(String phone, String password) {
        User user =null;
        try {
            String sql ="select * from user where phone=? and upassword=?";
             user=template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), phone, password);
        } catch (DataAccessException e) {
           return null;
        }

        return user;
    }

    /**
     * 根据电话号码查询用户
     * @param phone
     * @return 返回user
     */
    @Override
    public User findByPhone(String phone) {
        User user=null;
        try {
            String sql = "select * from user where phone = ?";
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),phone);
        } catch (DataAccessException e) {
            return null;
        }
        return user;
    }


    public void addUser(User user){
        String sql = "insert into user (uid,uname,upassword,phone,fid) values(?,?,?,?,?)";
        template.update(sql,user.getUid(),
                user.getUname(),
                user.getUpassword(),
                user.getPhone(),
                user.getFid());
    }

    public void updateFid(User user, String fid) {
        String sql = "update user set fid = ? where uid = ?";
        template.update(sql,fid,user.getUid());
    }
}
