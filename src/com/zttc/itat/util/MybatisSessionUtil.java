package com.zttc.itat.util;

import com.zttc.itat.test.TestMybatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by ¶« on 2016/2/13.
 */
public class MybatisSessionUtil {

    public static SqlSession getSession(){
        String resource="conf.xml";
        InputStream inputStream=TestMybatis.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sessionFactory.openSession(true);
        return sqlSession;
    }
}
