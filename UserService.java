package services;

import dao.UserDao;
import model.UserEntity;

import java.util.List;

public class UserService {

    private static UserDao usersDao = new UserDao();

    public UserService() {
    }

    public static UserEntity findUser(String name) {
        return usersDao.findByName(name);
    }

    public void saveUser(UserEntity user) {
        usersDao.save(user);
    }

    public void deleteUser(UserEntity user) {
        usersDao.delete(user);
    }

    public void updateUser(UserEntity user) {
        usersDao.update(user);
    }

    public List<UserEntity> findAllUsers() {
        return usersDao.findAll();
    }
}