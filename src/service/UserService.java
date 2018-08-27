package service;

import domain.Admin;
import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll();

    Admin login(Admin user);

    void delSelectedUser();

    void delUser(String id);

    void addUser(User user);

    void updateUser(User user);

    void delSelectedUser(String[] ids);

    User findUserById(String id);

    PageBean<User> findUserByPage(String currentPage, String rows);
}
