package com.lzh.fxmall.commons.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * sessionfactory封装，全局唯一
 */
public class MybatisSessionFactoryUtils {

    /**
     * 饿汉单例
     */
    public static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
    static{
        initSessionFactory();
    }

    private static void initSessionFactory(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.cfg.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory == null){
            initSessionFactory();
        }
        return sqlSessionFactory;
    }
    public static SqlSession getSession(){
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null){
            threadLocal.set(sqlSessionFactory.openSession());
        }
        return sqlSession;
    }
}
