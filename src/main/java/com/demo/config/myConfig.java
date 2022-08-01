package com.demo.config;

import ch.qos.logback.classic.db.names.ColumnName;
import ch.qos.logback.classic.db.names.SimpleDBNameResolver;
import ch.qos.logback.core.encoder.EncoderBase;
import com.demo.bean.Pet;
import com.demo.bean.User;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import java.beans.Encoder;

/**
 * @Configuration：告诉SringBoot这个是一个配置类 == 配置文件
 * 配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 配置类本身也是组件
 * proxyBeanMethods：代理bean的方法（动态代理）
 * Full(全配置)配置类组件之间有依赖关系，方法会被调用之前单实例组件
 * Lite(轻量级配置)配置类之间无依赖关系用lite模式加速容器启动过程
 * 解决组件依赖
 * @Conditional 满足指定条件才开始组件注入
 */
@Import({User.class, SimpleDBNameResolver.class}) //给容器中组件自动创建出两个类型的组件、默认组件的名字就是全类名（com.demo.bean.User）
@Configuration(proxyBeanMethods = true)
//@ConditionalOnMissingBean(name = "test") //容器中没有test这个组件的时候才注入user2
//@ImportResource("classpath:bean.xml")
@EnableConfigurationProperties(Pet.class)
public class myConfig {

    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */
    @Bean
    //@ConditionalOnBean(name = "test") //容器中有test这个组件的时候才注入user2
    public User user2() {
        return new User("青椒二号",20);
    }

    public Pet test() {
        return new Pet("蓝猫");
    }
}
