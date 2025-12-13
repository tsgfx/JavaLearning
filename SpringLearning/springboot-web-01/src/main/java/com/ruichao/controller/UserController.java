package com.ruichao.controller;

import com.ruichao.pojo.User;
import com.ruichao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // RestController = @Controller + @ResponseBody(将controller方法的返回值直接写入HTTP响应体，如果是对象或集合，会先转为json，再响应)
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/list")
    public List<User> list() throws Exception {
        List<User> userList = userService.findAll();

        // 3. 遍历集合，将User对象转为json，拼接为json数组并返回
        return userList;

//        // 1. 加载并读取user.txt文件
//        // InputStream in = new FileInputStream(new File("/Users/ruichao/workspace/JavaLearning/SpringLearning/springboot-web-01/src/main/resources/user.txt"));
//        InputStream in  = this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
//
//        // 2. 解析用户信息，封装为User对象，得到一个User对象集合
//        List<User> userList = lines.stream().map(line -> {
//            String[] parts = line.split(",");
//            Integer id = Integer.parseInt(parts[0]);
//            String username = parts[1];
//            String password = parts[2];
//            String name = parts[3];
//            Integer age = Integer.parseInt(parts[4]);
//            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            return new User(id, username, password, name, age, updateTime);
//        }).toList();
//
//        // 3. 遍历集合，将User对象转为json，拼接为json数组并返回
//        return userList;
    }
}
