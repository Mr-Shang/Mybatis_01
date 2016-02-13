package com.zttc.itat.dao;

import com.zttc.itat.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by ¶« on 2016/2/13.
 */
public interface UserMapper {

    @Insert(" INSERT into t_user (name,age) VALUES (#{name},#{age})")
    public void add(User user);
    @Delete(" DELETE FROM t_user WHERE id=#{id}")
    public void delete(int id);
    @Update("UPDATE t_user SET  name=#{name},age=#{age} WHERE id=#{id}")
    public void update(User user);
    @Select("select * from t_user where id = #{id}")
    public void select(int id);
    @Select("SELECT *FROM t_user")
    public List<User> selectAllUser();
}
