package com.shuriken.dal.generate;

/**
 * 项目常量
 */
public final class ProjectConstant {
    public static final String BASE_DAL_PACKAGE = "com.shuriken.customer.dal";//项目基础包名称

    public static final String MODEL_PACKAGE = BASE_DAL_PACKAGE + ".model";//Model所在包
    public static final String MAPPER_PACKAGE = BASE_DAL_PACKAGE + ".dao";//Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_DAL_PACKAGE +".service";//Service所在包
    public static final String SERVICE_IMPL_PACKAGE =SERVICE_PACKAGE + ".impl";//ServiceImpl所在包
    public static final String WEB_PACKAGE = "com.shuriken.customer.web";//Controller所在包

    public static final String MAPPER_INTERFACE_REFERENCE = "com.shuriken.customer.core.Mapper";//Mapper插件基础接口的完全限定名
}
