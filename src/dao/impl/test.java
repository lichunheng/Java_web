/*
package dao.impl;

import domain.Admin;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;


public class test {

    @Test
    public void test(){
        JdbcTemplate tmplate = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM admin WHERE username = ? AND PASSWORD = ?";
        Admin user = tmplate.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), "zhangsan","123");
        System.out.println(user);
    }
}
*/
