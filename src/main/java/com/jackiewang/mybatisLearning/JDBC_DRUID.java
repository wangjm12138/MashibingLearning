package com.jackiewang.mybatisLearning;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC_DRUID {
    private static final String URL = "jdbc:mysql://175.178.122.46:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true"; // 数据库URL

    public static void main(String[] args) throws Exception {
        // 1. 创建 Druid 数据源
        DruidDataSource dataSource = new DruidDataSource();

        // 2. 配置数据库连接信息（使用 mysql-connector-java）
        dataSource.setUrl(URL); // 数据库URL
        dataSource.setUsername("root"); // 数据库用户名
        dataSource.setPassword("mysql6779755"); // 数据库密码

        // 3. 配置连接池参数
        dataSource.setInitialSize(5); // 初始化连接数
        dataSource.setMaxActive(10);  // 最大连接数
        dataSource.setMinIdle(2);     // 最小空闲连接数
        dataSource.setMaxWait(60000); // 获取连接的最大等待时间（毫秒）

        // 4. 获取数据库连接
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM test");
             ResultSet resultSet = statement.executeQuery()) {

            // 5. 处理查询结果
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        }

        // 6. 关闭数据源（可选，通常在应用关闭时调用）
        dataSource.close();
    }
}
