package com.core.dao.imp;

import com.context.WorkContext;
import com.core.dao.Dao;
import com.domain.model.PageData;
import com.model.AuditModel;
import com.model.DeleteModel;
import com.utils.DateUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoImp implements Dao {


    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 保存对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    @Override
    public Integer save(String str, Object obj) throws Exception {
        return sqlSessionTemplate.insert(str,obj);
    }



    /**
     * 修改对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    @Override
    public Integer update(String str, Object obj) throws Exception {
        return sqlSessionTemplate.update(str,obj);
    }

    /**
     * 批量更新
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    public void batchUpdate(String str, List objs )throws Exception{
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        //批量执行器
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
        try{
            if(objs!=null){
                for(int i=0,size=objs.size();i<size;i++){
                    sqlSession.update(str, objs.get(i));
                }
                sqlSession.flushStatements();
                sqlSession.commit();
                sqlSession.clearCache();
            }
        }finally{
            sqlSession.close();
        }
    }

    /**
     * 删除对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    @Override
    public Integer delete(String str, Object obj) throws Exception {
        return sqlSessionTemplate.delete(str,obj);
    }

    /**
     * 批量删除
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    public Object batchDelete(String str, List objs )throws Exception{
        return sqlSessionTemplate.delete(str, objs);
    }

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    @Override
    public Object findForObject(String str, Object obj) throws Exception {
        return sqlSessionTemplate.selectOne(str,obj);
    }

    /**
     * 查找集合
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    @Override
    public Object findForList(String str, Object obj) throws Exception {
        return sqlSessionTemplate.selectList(str,obj);
    }

    /**
     * 动态sql查找list
     * @param str
     * @param pageData
     * @return
     */
    @Override
    public Object findForListSql(String str, PageData pageData) throws Exception{
        return sqlSessionTemplate.selectList(str,pageData);
    }

    /**
     * 根据ids批量删除（逻辑删除，更改is deleted字段）
     * @param str
     * @param deleteModels
     * @return
     */
    @Override
    public boolean deleteByIds(String str, List<DeleteModel> deleteModels) throws Exception{
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        //批量执行器
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.REUSE,false);
        try{
            if(deleteModels!=null && deleteModels.size()>0){
                for(DeleteModel deleteModel : deleteModels){
                    sqlSession.update(str,deleteModel);
                }
                sqlSession.flushStatements();
                sqlSession.commit();
                sqlSession.clearCache();
            }
        }catch (Exception e){
            return false;
        }finally{
            sqlSession.close();
        }
        return true;
    }


}
