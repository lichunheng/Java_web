package dao;

import domain.Admin;
import domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao{
    public List<User> findAll();

    Admin findUserByUsernameAndPassword(String username, String password);

    void delete(int id);

    void addUser(User user);

    void updateUser(User user);

    User findUserById(int id);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
