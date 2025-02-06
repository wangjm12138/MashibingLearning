package com.jackiewang.mybatisLearning;

import java.sql.*;

public class pureJDBC {

    // 数据库连接信息
    private static final String URL = "jdbc:mysql://175.178.122.46:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true"; // 数据库URL
    private static final String USER = "root"; // 数据库用户名
    private static final String PASSWORD = "mysql6779755"; // 数据库密码


    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 1. 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 建立数据库连接
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 3. 创建SQL语句
//            String sql = "SELECT id, name FROM test WHERE id = ?";
            String sql = "SELECT id, name FROM test";

            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, 1); // 设置参数

            // 4. 执行查询
            resultSet = preparedStatement.executeQuery();

            // 5. 处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("数据库驱动未找到！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("数据库操作失败！");
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
