package com.authorize.annotation;

import java.lang.annotation.*;


/**
 * 基础权限控制注解,提供基本的控制配置
 *
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Authorize {

    /**
     * 对角色授权,当使用按角色授权时，对模块以及操作级别授权方式失效
     *
     * @return 进 role id array
     */
    String[] role() default {};

    /**
     * 对模块授权
     *
     * @return permission id array
     * @see Permission#getId()
     */
    String[] permission() default {};

    /**
     * 如增删改查等
     *
     * @return action array
     * @see Permission#getActions()
     */
    String[] action() default {};

    /**
     * &#x9a8c;&#x8bc1;&#x662f;&#x5426;&#x4e3a;&#x6307;&#x5b9a;user
     *
     * @return username array
     *
     *
     */
    String[] user() default {};

    /**
     * 验证失败时返回的消息
     *
     * @return 验证失败提示的消息
     */
    String message() default "{unauthorized}";

    /**
     * 是否合并类上的注解
     *
     * @return 是否合并类上的注解
     */
    boolean merge() default true;

//    /**
//     * 验证模式，在使用多个验证条件时有效
//     *
//     * @return logical
//     */
//    Logical logical() default Logical.DEFAULT;

    /**
     * @return 是否忽略, 忽略后将不进行权限控制
     */
    boolean ignore() default false;
}
