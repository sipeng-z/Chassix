package com.casting.controller;

import com.casting.domain.model.input.MaterialInspectionRecordDetailInput;
import com.casting.domain.model.input.MaterialInspectionRecordInput;
import com.casting.domain.model.output.MaterialInspectionRecordOutput;
import com.casting.service.MaterialInspectionRecordDetailService;
import com.casting.service.MaterialInspectionRecordService;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.response.ResponseResult;
import com.system.domain.entity.SystemUsers;
import com.system.domain.model.output.SystemUsersOutput;

import com.system.service.SMTPEmailService;
import com.system.service.SystemUsersService;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "MaterialInspectionRecord")
public class MaterialInspectionRecordController extends GenericController <MaterialInspectionRecordInput,MaterialInspectionRecordOutput> {



    private final Logger logger = LoggerFactory.getLogger(MaterialInspectionRecordController.class);

    @Autowired
    private MaterialInspectionRecordService  materialInspectionRecordService;

    @Autowired
    private MaterialInspectionRecordDetailService materialInspectionRecordDetailService;

    @Autowired
    private SystemUsersService systemUsersService;



    @Autowired
    private SMTPEmailService smtpEmailService;


    @Override
    protected void OnActionExecuting() {
        materialInspectionRecordService.SetWorkContext(this.WorkContext);
    }


    protected AbstractService<MaterialInspectionRecordInput,MaterialInspectionRecordOutput> getService() {
        return materialInspectionRecordService;
    }





    /**
     * ADD/UPDATE
     * material is passed by LAB
     * request to Quality
     * @param id
     * @param input
     * @return
     */
    @Override
    @RequestMapping(value = "formpost",method = RequestMethod.POST)
    public ResponseResult formPost(String id, @RequestBody MaterialInspectionRecordInput input) {
        ResponseResult result = new ResponseResult();
        try{
            if(input==null){
                result.setMessage("@RequestBody M");
                result.setSuccess(false);
                return result;
            }
            Boolean flag = null;
            if(id==null||id.equals("")){
                flag =  materialInspectionRecordService.add(input);

            }else {
                flag =  materialInspectionRecordService.update(input);
            }
            if(flag==true){

                String[] to = new String[]{"huang.guohua@chassix.com","yyhuan@chassix.com"};   // target email adress , from email adress
                String subject = "Material Inspection Record Audit";
                String content = "The LAB operator completed the report, please confirm .</Br> Batch Number : ";
                content+=input.getBatchNumber();  //batch number from report
                content+="</Br>";
                content+="Best regards.</Br>";
                content+="</Br>";
                content+="Chassix Data Acquisition Project";

                Boolean flag2 = smtpEmailService.SendMail(to,subject,content);

                if(flag2!=true){
                    result.setMessage("Failure of sending email to Quality!");
                    result.setSuccess(false);
                    return result;
                }

                result.setMessage("Success,Email sent already!");
                result.setSuccess(true);
                return result;
            }else {
                result.setMessage("Error!");
                result.setSuccess(false);
                return result;
            }
        }catch (Exception e){
            logger.error("---------------------add/update error-------"+e);
            result.setMessage("error in progress");
            result.setMessage_detail(e.toString());
        }
        return result.error(CommonConstants.EX.EXCEPTION);
    }















    /**
     * PAGERLIST for Material inspection all list / with search
     * Get
     * @param request
     * @return
     */
    @RequestMapping(value = "pagerlist",method = RequestMethod.GET)
    public ResponseResult pagerList(HttpServletRequest request) {
        try{
            return ResponseResult.success(new PageInfo<>(materialInspectionRecordService.list(true,new PageData(request))));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }





    /**
     * GET
     * get by PKID
     */
    @RequestMapping(value = "getByNumber",method = RequestMethod.GET)
    public ResponseResult getByNumber(String batchNumber) {
        try{

            return ResponseResult.success(materialInspectionRecordService.getByBatchNumber(batchNumber));
        }catch (Exception e){
            logger.error("-----------------------getByNumber------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }





    /**
     * GET
     * get by PKID
     */
    @RequestMapping(value = "auditRecord",method = RequestMethod.GET)
    public ResponseResult auditRecord(String batchNumber) {
        try{
            ResponseResult result =  new ResponseResult();

            String userid = this.WorkContext.getUserId();

        SystemUsersOutput user =    systemUsersService.get(userid);

        if(!user.getUserType().equals("5")){
            result.setSuccess(false);
            result.setMessage("NO PERMISSION");
            return result;

        }
            Integer state = 1; // Audit pass
            boolean flag = materialInspectionRecordService.updateState(batchNumber,state);
            if(flag){
              result.setCode(200);
              result.setMessage("Audit Success");
              result.setSuccess(true);
              return result;
            }

            return result;
        }catch (Exception e){
            logger.error("-----------------------audit error------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }






    /**
     * GET
     * get by PKID
     */
    @RequestMapping(value = "reportQuality",method = RequestMethod.GET)
    public ResponseResult reportQuality(String batchNumber) {
        try{
            ResponseResult result =  new ResponseResult();


            String[] to = new String[]{"huang.guohua@chassix.com","yyhuan@chassix.com"};
            String subject = "Material Inspection Record Audit";
            String content = "The LAB operator completed the report, please confirm .</Br> Batch Number : ";
            content+=batchNumber;
            content+="</Br>";
            content+="Best regards.</Br>";
            content+="</Br>";
            content+="Chassix Data Acquisition Project";

            Boolean flag = smtpEmailService.SendMail(to,subject,content);

            if(flag){
                result.setCode(200);
                result.setMessage("Report Success");
                result.setSuccess(true);
                return result;
            }

            return result;
        }catch (Exception e){
            logger.error("-----------------------audit error------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }









    /**
     * GET
     * get by PKID
     */
    @RequestMapping(value = "smtptest",method = RequestMethod.GET)
    public ResponseResult smtptest(String batchNumber) {
        try{
            ResponseResult result =  new ResponseResult();

            String[] to = new String[]{"yyhuan@chassix.com"};
            String subject = "test subject";
            String content = "test content ....";


            Boolean flag = smtpEmailService.SendMail(to,subject,content);
            if(flag){
                result.setCode(200);
                result.setMessage("Report Success");
                result.setSuccess(true);
                return result;
            }

            return result;
        }catch (Exception e){
            logger.error("-----------------------audit error------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }














}
