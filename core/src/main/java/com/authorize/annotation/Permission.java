package com.authorize.annotation;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import java.io.Serializable;
import java.util.Set;


/**
 * 用户持有的权限信息,包含了权限基本信息、可操作范围(action)、行,列级权限控制规则。
 * 是用户权限的重要接口。
 */
public interface Permission extends Serializable {
    /**
     * 查询
     */
    String ACTION_QUERY  = "query";
    
    /**
     * 获取明细
     */
    String ACTION_GET    = "get";
    
    /**
     * 新增
     */
    String ACTION_ADD    = "add";
    
    /**
     * 更新
     */
    String ACTION_UPDATE = "update";
    

    /**
     * 删除
     */
    String ACTION_DELETE = "delete";
    
    /**
     * 导入
     */
    String ACTION_IMPORT = "import";
    
    /**
     * 导出
     */
    String ACTION_EXPORT = "export";
    

    /**
     * 禁用
     */
    String ACTION_DISABLE = "disable";
    

    /**
     * 启用
     */
    String ACTION_ENABLE = "enable";
    

    /**
     * @return 权限ID，权限的唯一标识
     */
    String getId();

    /**
     * @return 用户对此权限的可操作事件(按钮)
     */
    Set<String> getActions();

//    /**
//     * @return 用户对此权限持有的数据权限信息, 用于数据级别的控制
//     * @see DataAccessConfig
//     */
//    Set<DataAccessConfig> getDataAccesses();
}