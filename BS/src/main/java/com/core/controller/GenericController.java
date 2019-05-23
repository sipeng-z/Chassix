package com.core.controller;

import com.authorize.CurrentUserInfo;
import com.authorize.oauth2.OAuth2Manager;
import com.core.dao.imp.DaoImp;
import com.core.service.AbstractService;
import com.model.AppConsts;
import com.response.ResponseResult;
import com.system.domain.entity.SystemUsers;
import com.utils.MapperName;
import com.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.context.WorkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 *  public controller
 */
public abstract class GenericController<PI,PO> {
    private final Logger logger = LoggerFactory.getLogger(GenericController.class);

    @Autowired
    private DaoImp daoImp;

    //mapper方法名
    public  String MAPPERNAME = MapperName.Name.SystemUsersName;

    public WorkContext WorkContext = new WorkContext();

    protected abstract void OnActionExecuting();

    @ModelAttribute
    protected void Initialize() {
        SetCurrentUserId();
        SetCurrentUserInfo();
        OnActionExecuting();
    }

    /**
     * 将当前登陆的userid存入WorkContext中
     */
    private void SetCurrentUserId() {
        try {
            HttpServletRequest request = WebUtils.getHttpServletRequest();
            if (request != null) {
                OAuth2Manager manager = new OAuth2Manager();
                CurrentUserInfo currentUserInfo = manager.GetCurrentUserInfo(request);
                if (currentUserInfo != null) {
                    WorkContext.setUserId(currentUserInfo.getUserId());
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * 根据userid查找到userinfo，并存入WorkContext中
     */
    private void SetCurrentUserInfo() {
        try {
            if (WorkContext != null && !AppConsts.defaultGuId.equals(WorkContext.getUserId()) && !"".equals(WorkContext.getUserId())) {
                SystemUsers usersInfo = (SystemUsers)daoImp.findForObject(MAPPERNAME+"selectByPrimaryKey",this.WorkContext.getUserId());

                if (usersInfo != null) {
                    WorkContext.setAccount(usersInfo.getAccount());
                    WorkContext.setName(usersInfo.getName());
                    WorkContext.setNickname(usersInfo.getNickName());
                    WorkContext.setSuperAdministrator(
                            usersInfo.getLevel() != null && usersInfo.getLevel().equals(9));
                }
//
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //获取当前的service
    protected abstract AbstractService<PI,PO> getService();


    /**
     * 新增或增加
     * @param id
     * @param pi
     * @return
     * @throws Exception
     */
    public ResponseResult formPost(String id,PI pi) throws Exception {
        logger.info(this.WorkContext.getUserId()+": 进入frompost");
        ResponseResult result = new ResponseResult();
        String  rtMge = "";
        if(pi == null){
            return ResponseResult.error("参数错误");
        }
        boolean flag = false;
        if(id == null||id.equals("")){
            flag = getService().add(pi);
        }else {
            flag = getService().update(pi);
        }
        if(flag){
            rtMge = "Success!";
            result.setSuccess(flag);
        }else {
            rtMge = "Failure!";
            result.setSuccess(flag);
        }
        result.setMessage(rtMge);
        return result;
    }


    /**
     * 删除
     * @param idList
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ResponseResult delete(String idList) throws Exception {
        logger.info(this.WorkContext.getUserId()+": 进入delete");
        ResponseResult result = new ResponseResult();
        String rtMge = "";
        if(idList == null || "".equals(idList)){
            return ResponseResult.success();
        }
        boolean flag = getService().delete(idList);
        if(flag){
            rtMge = "删除成功";
            result.setSuccess(true);
        }else {
            rtMge = "删除失败";
            result.setSuccess(false);
        }
        result.setMessage(rtMge);
        return result;
    }

    /**
     * 分页列表
     * @param request
     * @return
     */
    public ResponseResult pagerList(HttpServletRequest request){
        logger.info(this.WorkContext.getUserId()+": 进入pagerlist");
        return null;
    }

    public ResponseResult get(String id) throws Exception {
        logger.info(this.WorkContext.getUserId()+": 进入get");
        if(id == null){
            return ResponseResult.error("参数错误");
        }
        return ResponseResult.success(getService().get(id));
    }

//    public ResponseResult get(Integer id) throws Exception {
//        logger.info(this.WorkContext.getUserId()+": 进入get");
//        if(id == null){
//            return ResponseResult.error("参数错误");
//        }
//        return ResponseResult.success(getService().get(id));
//    }




}