package com.thomas.products.mock;

public class UserServiceImpl{
    private UserDao userDao;
    public User query(String id){
        try{
            return userDao.getById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}