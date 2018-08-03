package com.shuriken.customer.dal;

import java.util.List;

import com.shuriken.customer.dal.mybatis.AuditingInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis & Mapper & PageHelper 配置
 */
@Configuration
@ComponentScan("com.shuriken.customer.dal")
@MapperScan(basePackages = "com.shuriken.customer.dal.dao")
@Slf4j
public class MybatisConfigurer {

    public MybatisConfigurer(){
        log.info("已加载配置[{}]", this.getClass().getSimpleName());
    }

    @Autowired
    @ConditionalOnBean(SqlSessionFactory.class)
    public void addAuditingInterceptor(List<SqlSessionFactory> sqlSessionFactoryList) {
        AuditingInterceptor interceptor = new AuditingInterceptor();
        sqlSessionFactoryList.forEach(
            sqlSessionFactory -> sqlSessionFactory.getConfiguration().addInterceptor(interceptor));
    }

}

