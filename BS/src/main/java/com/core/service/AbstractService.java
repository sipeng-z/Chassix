package com.core.service;
import com.context.WorkContext;
import com.core.dao.imp.DaoImp;
import com.domain.model.PageData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.model.AppConsts;
import com.model.AuditModel;
import com.model.DeleteModel;
import com.utils.DateUtils;
import com.utils.MapperName;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 *  public service
 */
public abstract class AbstractService<PI,PO> {


    @Autowired
    protected DaoImp daoImp;


    protected WorkContext WorkContext = new WorkContext();


    protected Integer getDefaultDisplayOrder() {
        return 0;
    }

    protected Integer getDefaultAuditState() {
        return 0;
    }

    protected Integer getDefaultState() {
        return 0;
    }




    /**
     * 获取当前登陆用户的id
     * @return
     */
    protected String getCurrentUserId() {
        String UserId = AppConsts.defaultGuId;
        UserId = WorkContext.getUserId();

        return UserId;
    }

    /**
     * 获取当前用户的name
     * @return
     */
    protected String getCurrentUserName() {
        String currentUserName = "-";
        if (WorkContext != null) {
            if (WorkContext.getName() != null && !WorkContext.getName().equals("")) {
                currentUserName = WorkContext.getName();
            }
        }
        return currentUserName;
    }

    /**
     * 获取当前用户的账号
     * @return
     */
    protected String getCurrentUserAccount() {
        String currentUserAccount = "-";
        if (WorkContext != null) {
            if (WorkContext.getAccount() != null && !WorkContext.getAccount().equals("")) {
                currentUserAccount = WorkContext.getAccount();
            }
        }
        return currentUserAccount;
    }

    /**
     * 获取当前登陆用户的账号和name
     * @return
     */
    protected String getCurrentUserNameWithAccount() {
        String userNameWithAccount = "-";
        if (WorkContext != null) {
            if (WorkContext.getName() != null && !WorkContext.getName().equals("")) {
                userNameWithAccount = WorkContext.getName();
                if (WorkContext.getAccount() != null && !WorkContext.getAccount().equals("")) {
                    userNameWithAccount = userNameWithAccount + "(" + WorkContext.getAccount() + ")";
                }
            } else {
                if (WorkContext.getAccount() != null && !WorkContext.getAccount().equals("")) {
                    userNameWithAccount = "(" + WorkContext.getAccount() + ")";
                }
            }
        }
        return userNameWithAccount;
    }

    /**
     * 判断当前登陆用户是否是管理员
     * @return
     */
    protected boolean isSuperAdministrator() {
        boolean superAdministrator = false;
        if (WorkContext != null) {
            superAdministrator = WorkContext.isSuperAdministrator();
        }
        return superAdministrator;
    }

    protected String getGUID(){
        return UUID.randomUUID().toString();
    }

    /**
     * 获取当前时间
     * @return
     */
    protected Date getNowTime() {
        return DateUtils.getNowDateTime();
    }


    public void SetWorkContext(WorkContext workContext) {
        this.WorkContext = workContext;
    }

    public abstract String getMapperName();



    public PageData poToMap(PI pi) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        if(pi==null){
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(pi.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter!=null && getter.invoke(pi)!=null ? getter.invoke(pi) : null;
            if(key.indexOf("Id")<0 && key.indexOf("id")<0){
                if(getter.toString().indexOf("java.util.Date")<0 && getter.toString().indexOf("java.lang.Integer")<0
                        && getter.toString().indexOf("java.lang.Long")<0 && getter.toString().indexOf("java.lang.Double")<0
                        && getter.toString().indexOf("java.math.BigDecimal")<0){
                    value = getter!=null && getter.invoke(pi)!=null ? getter.invoke(pi) : "";
                }
            }

            map.put(key, value);
        }
        PageData pageData = new PageData();
        pageData.setMap(map);
        return pageData;
    }


    /**
     * 分页公共方法
     * @param pageData //公共入参
     * @param mapperName//方法名
     * @param sqlStr//动态sql
     * @return
     * @throws Exception
     */
    public List<PO> pageList(PageData pageData,String mapperName,String sqlStr) throws Exception {
        Integer pagesize = pageData.getRows();
        Integer page = pageData.getPageIndex();
        PageHelper.startPage(page, pagesize);
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql",sqlStr);
        Page<PO> dataList = (Page<PO>) daoImp.findForListSql(mapperName,sqlModel);
        return dataList;
    }


    /**
     * 批量审核
     * @param mapperName
     * @param ids
     * @param state
     * @return
     * @throws Exception
     */
    public boolean auditByIds(String mapperName,String ids,Integer state) throws Exception {
        String[] strs = ids.split(",");
        if(strs.length<=0){
            return false;
        }
        List<AuditModel> list = new ArrayList<AuditModel>();
        for(String str : strs){
            AuditModel auditModel = new AuditModel();
            auditModel.setAuditbyuserid("'"+this.WorkContext.getUserId()+"'");
            auditModel.setAuditbyusername(this.WorkContext.getAccount());
            auditModel.setAuditdatetime(DateUtils.getNowDateTime());
            auditModel.setAuditstate(state);

            auditModel.setLastupdatedbyuserid("'"+this.WorkContext.getUserId()+"'");
            auditModel.setLastupdatedbyusername(this.WorkContext.getName());
            auditModel.setLastupdateddatetime(DateUtils.getNowDateTime());

            auditModel.setId("'"+str+"'");
            list.add(auditModel);
        }
        return daoImp.auditByIds(mapperName,list);
    }

    /**
     * 批量删除
     * @param mapperName
     * @param ids
     * @return
     * @throws Exception
     */
    public boolean deleteByIds(String mapperName,String ids) throws Exception {
        String[] strs = ids.split(",");
        if(strs.length<=0){
            return false;
        }
        List<DeleteModel> list = new ArrayList<DeleteModel>();
        for(String str : strs){
            DeleteModel deleteModel = new DeleteModel();

            deleteModel.setLastupdatedbyuserid("'"+this.WorkContext.getUserId()+"'");
            deleteModel.setLastupdatedbyusername(this.WorkContext.getName());
            deleteModel.setLastupdateddatetime(DateUtils.getNowDateTime());
            deleteModel.setIsDelete(AppConsts.IsDelete_Yes);
            deleteModel.setId("'"+str+"'");
            list.add(deleteModel);
        }
        return daoImp.deleteByIds(mapperName,list);
    }



    public boolean add(PI pi) throws Exception {
        int isDeleted=0;
        PageData pageData = this.poToMap(pi);
        pageData.put("createdUserId",this.WorkContext.getUserId());
        pageData.put("createdUserName",this.WorkContext.getName());
        pageData.put("createdDateTime",this.getNowTime());
        pageData.put("lastUpdatedUserId",this.WorkContext.getUserId());
        pageData.put("lastUpdatedUserName",this.WorkContext.getName());
        pageData.put("lastUpdateUser",this.WorkContext.getName());
        pageData.put("lastUpdateTime",this.getNowTime());
        pageData.put("lastUpdatedDateTime",this.getNowTime());
        pageData.put("isDeleted", AppConsts.IsDelete_No);
        pageData.put("auditState",AppConsts.Audit_Default);
        pageData.put("isDeleted",isDeleted);
        if(daoImp.save(getMapperName()+"insertSelective",pageData)>0){
            return true;
        }
        return false;
    }

    public boolean update(PI pi) throws Exception {
        PageData pageData = this.poToMap(pi);
        pageData.put("lastUpdatedUserId",this.WorkContext.getUserId());
        pageData.put("lastUpdatedUserName",this.WorkContext.getName());
        pageData.put("lastUpdatedDateTime",this.getNowTime());
        if(daoImp.update(getMapperName()+"updateByPrimaryKeySelective",pageData)>0){
            return true;
        }
        return false;
    }

    /**
     * 审核
     * @param idList
     * @param state
     * @return
     * @throws Exception
     */
    public boolean audit(String idList,Integer state) throws Exception {

        return this.auditByIds(getMapperName()+"audit",idList,state);
    }

    /**
     * 删除
     * @param idList
     * @return
     * @throws Exception
     */
    public boolean delete(String idList) throws Exception {
        return this.deleteByIds(getMapperName()+"delete",idList);
    }

    /**
     * 分页列表
     * @param isPager
     * @param pageData
     * @return
     * @throws Exception
     */
    public List<PO> list(boolean isPager,PageData pageData) throws Exception {
        if(isPager){
            return pageList(pageData,getMapperName()+"list",new PageData().where(pageData));
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql",new PageData().where(pageData));
        return (List<PO>) daoImp.findForListSql(getMapperName()+"list",sqlModel);
    }

    /**
     * 获取单个对象
     * @param id
     * @return
     * @throws Exception
     */
    public PO get(String id) throws Exception {
        PageData pageData = new PageData();
        pageData.put("id",id);
        return (PO) daoImp.findForObject(getMapperName()+"findByPkId",pageData);
    }

//    public PO get(Integer id) throws Exception {
//        PageData pageData = new PageData();
//        pageData.put("id",id);
//        return (PO) daoImp.findForObject(getMapperName()+"findByPkId",pageData);
//    }

}
