package com.demo;

import com.demo.bean.Pet;
import com.demo.bean.User;
import com.demo.config.myConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序的类
 * @SpringBootApplication：这个是一个SpringBoot应用
 */
@SpringBootApplication(scanBasePackages = "com.demo")
@MapperScan("com.demo.mapper")
public class MainDemo {
    public static void main(String[] args) {
        //1.返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainDemo.class, args);

        //2.查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name:names
             ) {
            System.out.println("获取当前IOC容器各个组件信息："+name);
        }

        //从容器中获取组件
        User tom1 = run.getBean("user2", User.class);

        User tom2 = run.getBean("user2", User.class);

        System.out.println("组件："+(tom1 == tom2));

        myConfig bean = run.getBean(myConfig.class);

        System.out.println(bean);

        User user1 = bean.user2();
        User user2 = bean.user2();
        System.out.println("bean的区别："+(user1 == user2)+ " 数据1："+ user1 + "数据2："+ user2);

        //获取带有对应的组件类型的Bean
        String[] myType = run.getBeanNamesForType(User.class);

        for (String s:myType
             ) {
            System.out.println("组件类型："+s);
        }
        System.out.println("获取当前编译格式信息：" + System.getProperty("file.encoding"));
    }
}
