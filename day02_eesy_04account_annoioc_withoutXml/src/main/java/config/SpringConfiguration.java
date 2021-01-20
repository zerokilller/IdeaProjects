package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 *@Description:该类是一个配置类，他的作用和bean.xml一样
 *@Author:景文博
 *@Param:
 *@Return:
 *Spring的新注解:
 *  @Configuration :指定当前类是一个配置类
 *  @ComponentScan :用于通过注解指定Spring在创建容器时要扫描的包
 *                  属性(basePackages):他和value的作用是一样的，都是用于指定
 *                  创建容器时要扫描的包，我们使用此注解，相当于在xml中配置了:
 *       <context:component-scan base-package="com.itheima"> </context:component-scan>
 *  @Bean :用于把当前方法的返回值作为bean对象存入SpringIoc容器。
 *         属性(name):用于指定bean的id。当不写时，默认值为当前方法的名称。
 *     细节:当我们使用注解配置方法时，如果方法有参数，Spring框架会去容器中查找有没有可用的bean对象。
 *         查找的方式和Autowired注解的方式是一样的。
 * @Import :用于倒入其他配置类
 *      属性:
 *          value:用于指定其他配置类的字节码。
 *      细节:当我们使用Import注解之后，有Import注解的类为主配置类，而导入的都是子配置类。
 *@PropertySource
 *      作用:用于指定properties文件的位置。
 *      属性:
 *          value:用于指定文件的名称和路径。
 *              关键字:classPath,表示当前路径为类路径
 */
//@Configuration
@ComponentScan(basePackages = {"com.itheima"})
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")  //classPath表示当前路径为类路径
public class SpringConfiguration {
}
