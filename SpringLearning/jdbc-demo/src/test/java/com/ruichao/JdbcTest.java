package com.ruichao;

import com.ruichao.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcTest {
    @Test
    public void testUpdate() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "123456Qq";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 3. 获取Sql语句执行对象
        Statement statement = connection.createStatement();

        // 4. 执行Sql语句
        int i = statement.executeUpdate("update user set age=25 where id=1");
        System.out.println("Sql执行完毕影响的记录数量为： " + i);

        // 5. 释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testSelect() throws Exception {
        // 数据库连接参数
        String URL = "jdbc:mysql://localhost:3306/web01";
        String USERNAME = "root";
        String PASSWORD = "123456Qq";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 1. 注册驱动并获取连接
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 2. 定义SQL语句
            String sql = "SELECT id, username, password, name, age FROM user WHERE username = ? AND password = ?";

            // 3. 获取PreparedStatement对象
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "daqiao");
            preparedStatement.setString(2, "123456");

            // 4. 执行SQL并获取结果集
            resultSet = preparedStatement.executeQuery();

            // 5. 处理结果集
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));

                // 输出User对象数据到控制台
                System.out.println(user);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 关闭资源
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
