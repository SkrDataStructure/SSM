package com.cookie.shop.prototype.dao;

import com.cookie.shop.prototype.model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.cookie.shop.prototype.utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    public void addUser(User t_user) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into t_user(username,email,password,name,phone,address,isadmin,isvalidate) values(?,?,?,?,?,?,?,?)";
        r.update(sql,t_user.getUsername(),t_user.getEmail(),t_user.getPassword(),t_user.getName(),t_user.getPhone(),t_user.getAddress(),t_user.isIsadmin(),t_user.isIsvalidate());
    }
    public boolean isUsernameExist(String username) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from t_user where username = ?";
        User u = r.query(sql, new BeanHandler<User>(User.class),username);
        if(u==null) {
            return false;
        }else {
            return true;
        }
    }
    public boolean isEmailExist(String email) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from t_user where email = ?";
        User u = r.query(sql, new BeanHandler<User>(User.class),email);
        if(u==null) {
            return false;
        }else {
            return true;
        }
    }
    public User selectByUsernamePassword(String username,String password) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from t_user where username=? and password=?";
        return r.query(sql, new BeanHandler<User>(User.class),username,password);
    }
    public User selectByEmailPassword(String email,String password) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from t_user where email=? and password=?";
        return r.query(sql, new BeanHandler<User>(User.class),email,password);
    }
    public User selectById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from t_user where id=?";
        return r.query(sql, new BeanHandler<User>(User.class),id);
    }

    public void updateUserAddress(User t_user) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql ="update t_user set name = ?,phone=?,address=? where id = ?";
        r.update(sql,t_user.getName(),t_user.getPhone(),t_user.getAddress(),t_user.getId());
    }
    public void updatePwd(User t_user) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql ="update t_user set password = ? where id = ?";
        r.update(sql,t_user.getPassword(),t_user.getId());
    }
    public int selectUserCount() throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from t_user";
        return r.query(sql, new ScalarHandler<Long>()).intValue();
    }
    public List selectUserList(int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from t_user limit ?,?";
        return r.query(sql, new BeanListHandler<User>(User.class), (pageNo-1)*pageSize,pageSize );
    }
    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from t_user where id = ?";
        r.update(sql,id);
    }
}
