package com.ruichao;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("单元测试demo")
public class UserServiceTest {

    @BeforeAll // 在所有单元测试方法运行之前，运行一次
    public static void beforeAll(){
        System.out.println("before all");
    }

    @AfterAll // 在所有单元测试方法运行之后，运行一次
    public static void afterAll(){
        System.out.println("after all");
    }

    @BeforeEach // 在每个单元测试方法运行之前，运行一次
    public void beforeEach(){
        System.out.println("before each");
    }

    @AfterEach // 在每个单元测试方法运行之后，运行一次
    public void afterEach(){
        System.out.println("after each");
    }

    @Test
    public void testGetAge(){
        UserService userService = new UserService();
        Integer age = userService.getAge("100000200010011011");
        System.out.println(age);
    }

    @Test
    public void testGenderWithAssert(){
        UserService userService = new UserService();
        String gender = userService.getGender("100000200010011011");
        // 断言
        Assertions.assertEquals("男", gender, "性别获取逻辑出错");
    }

    @Test
    public void testGenderWithAssert2(){
        UserService userService = new UserService();
        String gender = userService.getGender("100000200010011011");
        // 异常断言
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender(null);
        });
    }

    @DisplayName("参数化测试性别")
    @ParameterizedTest
    @ValueSource(strings = {"100000200010011011", "100000200010011031", "100000200010011051"})
    public void testGetGender(String idCard){
        UserService userService = new UserService();
        String gender = userService.getGender(idCard);
        // 断言
        Assertions.assertEquals("男", gender, "性别获取逻辑出错");
    }
}
