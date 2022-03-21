package com.oop.Demo05;


//接口都需要实现类
public interface UserService {
    //接口中所有的定义都是抽象的public abstract

    void add(String name);
    void delete(String name);
    void update(String name);
    void query(String name);
}
