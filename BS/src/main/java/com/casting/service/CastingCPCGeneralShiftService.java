package com.casting.service;

import com.casting.domain.model.input.CastingCPCGeneralShiftInput;
import com.casting.domain.model.output.CastingCPCGeneralShiftOutput;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.utils.MapperName;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CastingCPCGeneralShiftService extends AbstractService<CastingCPCGeneralShiftInput,CastingCPCGeneralShiftOutput> {

   private final String generalName = AppConsts.CastingCPCGeneralShiftName;
    private String mapperName = generalName;

    @Override
    public String getMapperName() {
        return mapperName;
    }


    public void setMapperName(String mapperName){
        this.mapperName = mapperName;
    }

    /**
     * ADD new shiftId
     * @param input
     * @return
     * @throws Exception
     */

    public  boolean generaladd(CastingCPCGeneralShiftInput input,String device) throws  Exception{
        this.setMapperName(AppConsts.CastingCPCGeneralShiftName.replace("General",device));
        if(input.getShiftId()==null||!input.getShiftId().equals("")){
            input.setShiftId(super.getGUID());

        }


        int isDeleted=0;
        PageData pageData = super.poToMap(input);
        pageData.put("createdUserId",this.WorkContext.getUserId());
        pageData.put("createdUserName",this.WorkContext.getName());
        pageData.put("createdDateTime",this.getNowTime());
        pageData.put("lastUpdatedUserId",this.WorkContext.getUserId());
        pageData.put("lastUpdatedUserName",this.WorkContext.getName());
        pageData.put("lastUpdatedDateTime",this.getNowTime());
        pageData.put("isDeleted", AppConsts.IsDelete_No);
        pageData.put("auditState",AppConsts.Audit_Default);
        pageData.put("isDeleted",isDeleted);
        if(daoImp.save(mapperName+"insertSelective",pageData)>0){
            return true;
        }
        return false;


    }


    /**
     * update new shiftId
     * @param input
     * @return
     * @throws Exception
     */

    public  boolean generalupdate(CastingCPCGeneralShiftInput input,String device) throws  Exception{
        this.setMapperName(AppConsts.CastingCPCGeneralShiftName.replace("General",device));
        PageData pageData = super.poToMap(input);
        pageData.put("lastUpdatedUserId",this.WorkContext.getUserId());
        pageData.put("lastUpdatedUserName",this.WorkContext.getName());
        pageData.put("lastUpdatedDateTime",this.getNowTime());
        if(daoImp.update(mapperName+"updateByPrimaryKeySelective",pageData)>0){
            return true;
        }
        return false;
    }


    /**
     * General get for shift
     * @param id
     * @return
     * @throws Exception
     */
    public CastingCPCGeneralShiftOutput generalget(String id,String device) throws Exception {
       this.setMapperName(AppConsts.CastingCPCGeneralShiftName.replace("General",device));
        PageData pageData = new PageData();
        pageData.put("id",id);
        return (CastingCPCGeneralShiftOutput) daoImp.findForObject(mapperName+"findByPkId",pageData);
    }




    /**
     * add shift plan by DEFAULT
     * @param input
     * @return
     * @throws Exception
     */
    public  Integer addByDefault(CastingCPCGeneralShiftInput input,String device) throws Exception{
        this.setMapperName(AppConsts.CastingCPCGeneralShiftName.replace("General",device));
        //first of all, make sure the shift paln will be created in the fist time
        Integer weekNo = input.getWeekNo();
        PageData pageData = new PageData();
        pageData.put("weekNo",weekNo.toString());
        List<CastingCPCGeneralShiftInput> listbyweekno = (List<CastingCPCGeneralShiftInput>) daoImp.findForListSql(mapperName+"listbyweekno",pageData);
        if(listbyweekno.size()>=1){
            return 0;
        }
        String shift1 = input.getShift1();
        String shift2 = input.getShift2();
        String shift3 = input.getShift3();
        if(shift1!=null&&shift2!=null&&shift3!=null
                &&!shift1.equals("")&& !shift2.equals("")&&!shift3.equals("")){



            List<CastingCPCGeneralShiftInput> list = new ArrayList<>();

            CastingCPCGeneralShiftInput input1 = this.input4list(shift1);
            input1.setShiftName("SHIFT1");
            input1.setDisplayorder(1);
            CastingCPCGeneralShiftInput input2 = this.input4list(shift2);
            input2.setShiftName("SHIFT2");
            input.setDisplayorder(2);
            CastingCPCGeneralShiftInput input3 = this.input4list(shift3);
            input3.setShiftName("SHIFT3");
            input.setDisplayorder(3);
            list.add(input1);
            list.add(input2);
            list.add(input3);


            for(CastingCPCGeneralShiftInput c :list){
                c.setWeekNo(input.getWeekNo());
                super.add(c);
            }
            return 1;
        }
        return 3;
    }




    /**
     * default Mon - all week
     * @param shift
     * @return
     */
    private CastingCPCGeneralShiftInput input4list(String shift){

        if(shift==null){
            return null;
        }
        CastingCPCGeneralShiftInput input = new CastingCPCGeneralShiftInput();
        input.setShiftId(super.getGUID());
        input.setMon(shift);
        input.setTue(shift);
        input.setWed(shift);
        input.setThu(shift);
        input.setFri(shift);
//        input.setSat(shift);
//        input.setSun(shift);
        input.setMark(0);                            //  make sure mark is 0
        return input;
    }






    /**
     * LIST
     * @param isPager
     * @param pageData
     * @return
     * @throws Exception
     */

    public List<CastingCPCGeneralShiftOutput> generallist(boolean isPager,PageData pageData,String device) throws Exception {

       this.setMapperName(AppConsts.CastingCPCGeneralShiftName.replace("General",device));
        StringBuilder sb = new StringBuilder();

        if (pageData.containsKey("weekNo")) {
            sb.append(" AND week_no = " + "'" + pageData.getMap().get("weekNo") + "'");
        }

        if (pageData.containsKey("year")) {
            sb.append(" AND convert(varchar(4),created_date_time,120) like " + "'" + pageData.getMap().get("year") + "%'");
        }



        sb.append(new PageData().where(pageData));

        if(isPager){
            return pageList(pageData,mapperName+"list",sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql",new PageData().where(pageData));
        sqlModel.put("retrieveSql", sb.toString());

        return (List<CastingCPCGeneralShiftOutput>) daoImp.findForListSql(mapperName+"list",sqlModel);
    }











    /**
     * list by mark
     * @param mark
     * @return
     * @throws Exception
     */
    public List<CastingCPCGeneralShiftOutput> listbymark(Integer mark,String device) throws Exception {
        PageData pageData = new PageData();
        pageData.put("mark",mark.toString());
        return (List<CastingCPCGeneralShiftOutput>)daoImp.findForListSql(AppConsts.CastingCPCGeneralShiftName.replace("General",device)+"listbymark",pageData);
    }

    /**
     * After syn update mark
     * @param mark
     * @return
     * @throws Exception
     */

    public boolean updateMark(Integer mark,String pkId,String device) throws  Exception{

        PageData pageData = new PageData();
        pageData.put("mark",mark.toString());
        pageData.put("shiftId",pkId);

        if(daoImp.update(AppConsts.CastingCPCGeneralShiftName.replace("General",device)+"updateMark",pageData)>0){
            return true;
        }
        return false;

    }






}
