package com.shuriken.customer.dal.mybatis;

import java.util.Date;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.util.ReflectionUtils;

/**
 * Created by wb-wyh270612 on 2018/8/3.
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),

})
public class AuditingInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement)invocation.getArgs()[0];
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        Object parameter = invocation.getArgs()[1];
        reflectToAuditing(parameter, sqlCommandType);

        return invocation.proceed();
    }

    private void reflectToAuditing(Object entity, SqlCommandType sqlCommandType) throws IllegalAccessException {
        Date currentDate = new Date();
        if (SqlCommandType.UPDATE == sqlCommandType) {
            ReflectionUtils.doWithFields(entity.getClass(),
                    field -> {
                        field.setAccessible(true);
                        field.set(entity, currentDate);
                        field.setAccessible(false);
                    },
                    field -> AnnotationUtils.getAnnotation(field, LastModifiedDate.class) != null
            );
        } else if (SqlCommandType.INSERT == sqlCommandType) {
            ReflectionUtils.doWithFields(entity.getClass(),
                    field -> {
                        field.setAccessible(true);
                        field.set(entity, currentDate);
                        field.setAccessible(false);
                    },
                    field -> AnnotationUtils.getAnnotation(field, CreatedDate.class) != null
            );
        }
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
