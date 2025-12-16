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
    public List<User> findAll();
}
