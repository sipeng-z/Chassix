package com.core.dao;

import com.domain.model.PageData;
import com.model.AuditModel;
import com.model.DeleteModel;

import java.util.List;

/**
 *
 *  database access object
 */
public interface Dao {
    /**
     * 保存对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Integer save(String str, Object obj) throws Exception;

    /**
     * 修改对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Integer update(String str, Object obj) throws Exception;

    /**
     * 删除对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Integer delete(String str, Object obj) throws Exception;

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForObject(String str, Object obj) throws Exception;

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForList(String str, Object obj) throws Exception;

    /**
     * 动态sql查找list
     * @param str
     * @param pageData
     * @return
     */
    public Object findForListSql(String str, PageData pageData) throws Exception;


    /**
     * 根据ids批量删除
     * @param str
     * @param deleteModels
     * @return
     */
    public boolean deleteByIds(String str, List<DeleteModel> deleteModels) throws Exception;





}
