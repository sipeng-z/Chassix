package com.casting.controller;

import com.casting.domain.entity.CurveNeed;
import com.casting.domain.model.input.CastingCPCGeneralPvFurnaceChamberCurveInput;
import com.casting.domain.model.output.CastingCPCGeneralPvFurnaceChamberCurveOutput;
import com.casting.service.CastingCPCGeneralPvFurnaceChamberCurveService;
import com.casting.service.FloatParse.SixteenToFloat;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "generalCastingCPC")
@RestController
public class CastingCPCGeneralPvFurnaceChamberCurveController extends GenericController<CastingCPCGeneralPvFurnaceChamberCurveInput,CastingCPCGeneralPvFurnaceChamberCurveOutput> {

    private final Logger logger = LoggerFactory.getLogger(CastingCPCGeneralPvFurnaceChamberCurveController.class);


    @Autowired
    private CastingCPCGeneralPvFurnaceChamberCurveService castingCPCGeneralPvFurnaceChamberCurveService;

    @Override
    protected void OnActionExecuting() {
        castingCPCGeneralPvFurnaceChamberCurveService.SetWorkContext(this.WorkContext);
    }


    protected AbstractService<CastingCPCGeneralPvFurnaceChamberCurveInput,CastingCPCGeneralPvFurnaceChamberCurveOutput> getService() {
        return castingCPCGeneralPvFurnaceChamberCurveService;
    }




    /**
     * PAGELIST
     * @param
     * @return
     */

    @RequestMapping(value = "generalpagerlist",method = RequestMethod.GET)
    public ResponseResult generalpagerList(HttpServletRequest request,String device) {
        try{
            return ResponseResult.success(new PageInfo<>(castingCPCGeneralPvFurnaceChamberCurveService.generallist(true,new PageData(request),device)));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }







    /**
     * PAGELIST
     * @param request
     * @return F, C ,R
     */

    @RequestMapping(value = "generalgetcurve",method = RequestMethod.GET)
    public ResponseResult generalGetCurve(HttpServletRequest request,String device) {
        try{

            ResponseResult result = new ResponseResult();
            PageData pageData = new PageData(request);
           List<CastingCPCGeneralPvFurnaceChamberCurveOutput> reslist = castingCPCGeneralPvFurnaceChamberCurveService.getPoint(pageData,device);


           List<String> ppF = new ArrayList();
            List<String> ppC = new ArrayList();

            String TimeString ="";

           for(CastingCPCGeneralPvFurnaceChamberCurveOutput c :reslist){
               String pointlist = c.getPointMatrixString(); //push position 8 （16 type） to list, then it could be used to cal to (10 type)
               String type = c.getFurnaceChamber();
               if(type.equals("Furnace")){
                   for(int i=0;i<pointlist.length();i+=8){
                       ppF.add(pointlist.substring(i,i+8));
                   }
               }
               if(type.equals("Chamber")){
                   for(int i=0;i<pointlist.length();i+=8){
                       ppC.add(pointlist.substring(i,i+8));
                   }
               }

               TimeString = c.getTimeString();
           }


            CurveNeed curveNeed = new CurveNeed();

           List<String> piontsF = new ArrayList<>();
            List<String> piontsC = new ArrayList<>();
            List<String> piontsR = new ArrayList<>();
           for(String po : ppF){

               Long l = SixteenToFloat.parseLong(po.trim(), 16);
               Float f = Float.intBitsToFloat(l.intValue());
               piontsF.add(f.toString());

           }
            for(String po : ppC){

                Long l = SixteenToFloat.parseLong(po.trim(), 16);
                Float f = Float.intBitsToFloat(l.intValue());
                piontsC.add(f.toString());
            }

            for(int i =0;i<piontsC.size();i++){
               Float f = Float.valueOf(piontsF.get(i));
                Float c = Float.valueOf(piontsC.get(i));
                Float r  = f-c;

                piontsR.add(r.toString());
               }

            curveNeed.setF(piontsF);
            curveNeed.setC(piontsC);
            curveNeed.setR(piontsR);
            result.setCode(200);
            result.setSuccess(true);
            result.setMessage(TimeString);
            result.setData(curveNeed);

            return result;


        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }



}
