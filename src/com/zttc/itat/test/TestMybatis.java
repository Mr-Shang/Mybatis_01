package com.zttc.itat.test;

import com.zttc.itat.dao.UserMapper;
import com.zttc.itat.model.Class;
import com.zttc.itat.model.ConditionUser;
import com.zttc.itat.model.User;
import com.zttc.itat.util.MybatisSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by �� on 2016/2/13.
 */
public class TestMybatis {


    @Test
   public  void select(){

       String resource="conf.xml";
       InputStream inputStream=TestMybatis.class.getClassLoader().getResourceAsStream(resource);
       SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
       SqlSession sqlSession=sessionFactory.openSession();
       String select="com.zttc.itat.model.UserMapper.selectUser";
       User user= sqlSession.selectOne(select, 2);
       System.out.println(user);
    }
    @Test
    public  void add(){
        User user=new User(-1,"张飞","25");
        String statement="com.zttc.itat.model.UserMapper.insertUser";
        SqlSession sqlSession=MybatisSessionUtil.getSession();
        int insert=sqlSession.insert(statement, user);
//        默认是手动提交的，
        sqlSession.commit();
        sqlSession.close();
        System.out.println(insert);
    }

    @Test
    public void update(){
        String statement="com.zttc.itat.model.UserMapper.updateUser";
        SqlSession sqlSession=MybatisSessionUtil.getSession();
        int insert=sqlSession.update(statement, new User(1, "曹操", "48"));
//        默认是手动提交的，
        sqlSession.commit();
        sqlSession.close();
        System.out.println(insert);
    }
    @Test
    public  void  delete(){
        String statement="com.zttc.itat.model.UserMapper.deleteUser";
        SqlSession sqlSession=MybatisSessionUtil.getSession();
        int delete=sqlSession.delete(statement, 1);
//        默认是手动提交的，
        sqlSession.commit();
        sqlSession.close();
        System.out.println(delete);
    }

    @Test
    public void seleteAllUser(){
        String statement="com.zttc.itat.modelUserMapper.selectAllUser";
        SqlSession sqlSession=MybatisSessionUtil.getSession();
        List<User> list= sqlSession.selectList(statement);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(list);
    }
    @Test
    public void add02(){
        SqlSession sqlSession=MybatisSessionUtil.getSession();
        User user=new User(-1,"吕布","30");
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.add(user);
        sqlSession.close();
    }
    @Test
    public  void update02(){
        SqlSession sqlSession=MybatisSessionUtil.getSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.update(new User(6,"典韦","35"));
        sqlSession.close();
    }
    @Test
    public void  delete02(){
        SqlSession sqlSession=MybatisSessionUtil.getSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.delete(6);
        sqlSession.close();
    }
    @Test
    public void selectAll(){
        SqlSession sqlSession=MybatisSessionUtil.getSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
         List<User> user= (List<User>) userMapper.selectAllUser();
        sqlSession.close();
        System.out.println(user);
    }
    @Test
    public void getClasses(){
        SqlSession sqlSession=MybatisSessionUtil.getSession();
        String statement="com.zttc.itat.model.ClassesMapper.getClass";
        Class c=sqlSession.selectOne(statement,1);
        System.out.println(c);

    }
    @Test
    public void testOO2() {
        SqlSession sqlSession = MybatisSessionUtil.getSession();
        Class c = sqlSession.selectOne("com.zttc.itat.model.ClassesMapper.getClass2", 1);
        System.out.println(c);
    }
    @Test
    public void testOneToMany(){
        SqlSession sqlSession=MybatisSessionUtil.getSession();
        String statement="com.zttc.itat.model.ClassesMapper.getClassStudent";
        Class c=sqlSession.selectOne(statement,2);
        System.out.println(c);
        sqlSession.close();
    }
    @Test
    public void testOneToMany02(){
        SqlSession sqlSession=MybatisSessionUtil.getSession();
        String statement="com.zttc.itat.model.ClassesMapper.getClass4";
        Class c=sqlSession.selectOne(statement,2);
        System.out.println(c);
        sqlSession.close();
    }
    @Test
    public void getUser(){
        SqlSession sqlSession=MybatisSessionUtil.getSession();
        String statement="com.zttc.itat.model.UserMapper.getUser";
        String name="o";
        name=null;
        System.out.println(name+"……");
        ConditionUser conditionUser=new ConditionUser("'%"+name+"%'",13,20);
        List<User> userList=sqlSession.selectList(statement, conditionUser);
        System.out.println(userList);
        sqlSession.close();
    }

}
