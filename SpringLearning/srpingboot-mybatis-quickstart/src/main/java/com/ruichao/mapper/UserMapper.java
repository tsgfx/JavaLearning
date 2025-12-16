package com.ruichao.mapper;

import com.ruichao.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();

    /**
     * 根据id删除用户
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    public void deleteById(Integer id);

    /**
     * 添加用户
     */
    @Insert("insert into user(username, password, name, age) values (#{username}, #{password}, #{name}, #{age})")
    public void insert(User user);

    /**
     * 修改用户
     */
    @Update("update user set username=#{username}, password=#{password}, name=#{name}, age=#{age} where id=#{id}")
    public void update(User user);

    /**
     * 查询用户
     */
    @Select("select * from user where username=#{username} and password=#{password}")
    public User select(@Param("username") String username, @Param("password") String password);
}
