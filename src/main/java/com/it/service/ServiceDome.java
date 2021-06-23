package com.it.service;

import com.it.dao.UserMapper;
import com.it.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class ServiceDome {

    public static void main(String[] args) throws IOException {
        /*//从工具方法中获取 SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.userList();
        sqlSession.commit();
        System.out.println(users);*/
        User user1 = new User();
        user1.setId(4);
        user1.setUsername("fnasd");
        user1.setPassword("7909");
        user1.setBirthday(new Date());

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        System.out.println(userList);

        User user = mapper.findById(2);
        System.out.println(user);

        mapper.save(user1);

        sqlSession.commit();
        sqlSession.close();

    }


}
