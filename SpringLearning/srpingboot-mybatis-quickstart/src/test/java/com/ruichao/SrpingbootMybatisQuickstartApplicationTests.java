package com.ruichao;

import com.ruichao.mapper.UserMapper;
import com.ruichao.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest // 该注解会在单元测试运行时，加载springboot的环境
class SrpingbootMybatisQuickstartApplicationTests {

    @Autowired // 依赖注入
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(1);
    }

    @Test
    public void testInsert() {
        User user = new User(null, "daqiao", "123456", "大乔", 18);
        userMapper.insert(user);
    }

    @Test
    public void testUpdate() {
        User user = new User(6, "daqiao", "123456", "大乔", 21);
        userMapper.update(user);
    }

    @Test
    public void testFindByUsernameAndPassword() {
        User user = userMapper.select("daqiao", "123456");
        System.out.println(user);
    }
}
