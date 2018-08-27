package service.Impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.Admin;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    public Admin login(Admin user){
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void delSelectedUser() {

    }

    @Override
    public void delUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if (ids != null && ids.length > 0){
            for (String id : ids){
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currentPage <= 0){
            currentPage = 1;
        }

        //创建空的PageBean 对象
        PageBean<User> pb = new PageBean<User>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //调用dao查询总记录
        int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);

        //调用dao查询List集合
        int start = (currentPage -1) * rows;
        List<User> list = dao.findByPage(start,rows);
        pb.setList(list);

        //计算总的页码数
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

}
