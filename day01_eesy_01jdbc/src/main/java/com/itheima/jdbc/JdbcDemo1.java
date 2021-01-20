package com.itheima.jdbc;


import java.sql.*;

/**
 * 程序的耦合
 *      耦合:程序间的依赖关系
 *          包括：类之间的依赖   方法之间的依赖
 *      解耦:降低程序间的耦合关系
 *      实际开放中:应该做到:编译期不依赖,运行时依赖。
 *      解耦的思路:
 *              第一步:使用反射来创建对象，而避免使用new关键字。
 *              第二步:通过读取配置文件来获取要创建的对象全限定类名。
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //mysql操作数据库的jdbc操作:
        //1.注册驱动
        //DriverManager.registerDriver(new com.mysql.jdb c.Driver());
            Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy","root","992239901jwb");
        //3.获取操作数据库的预处理对象
        PreparedStatement preparedStatement = connection.prepareStatement("select * from account");
        //4.执行sql,得到结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        //5.遍历结果集
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
        //6.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
