package com.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AppConsts {

	public final static Integer IsDelete_Yes = 1;
	public final static Integer IsDelete_No = 0;

	public final static Integer Audit_Default = 0;
	public final static Integer Audit_Yes = 1;
	public final static Integer Audit_No = 3;

	public final static Integer State_Yes = 1;
	public final static Integer State_No = 0;

	public final static Integer IsShow_Yes = 0;
	public final static Integer IsShow_No = 1;

	public final static Integer Type_Default = 0;

	public final static Integer IsAddSelfRule_Yes = 0;
	public final static Integer IsAddSelfRule_No = 1;

	public final static String  IsAdminstrator= "AA";
	public final static String  IsAdminstratorEmployee= "AM";
	public final static String  IsEmployee= "MM";

	public final static Integer  AttendanceType=1 ;
	public final static Integer  consumeType=2 ;
	public final static Integer  doorType= 3;

	public final static Integer  IsDirectConnection_Yes= 0;
	public final static Integer  IsDirectConnection_No= 1;


	//编号是否按规则自增  0：否   1：是
	public final static Integer isSelfAdd_no =0;

	public final static Integer isSelfAdd_yes =1;



	public final static String defaultGuId = "00000000-0000-0000-0000-000000000000";

	public final  static BigDecimal rewardAmount = new BigDecimal("0.80");


	public final  static Integer[] shift1  = {1,32};

	public  final static Integer[] shift2 = {33,64};

	public final static Integer[] shift3 = {65,96};


	public final  static Integer[] shift1OverTime  = {81,32};// in 2 days

	public  final static Integer[] shift2OverTime = {33,80};

	public final static Integer[] shift3OverTime = {49,96};



	// sz_new_plant 10.41.32.2 (szo)
	public  final  static String dbUrlForCPCPointConnection = "jdbc:sqlserver://10.41.32.2:1433;DatabaseName=SZ_001;";



	//WORKBENCH JS API -- machine real time data
	public final static String workBenchUrl ="http://10.21.32.2:8081/api";

	public final static String workBenchLoginUrl ="http://10.21.32.2:8081/api/login";

	public final static String workBenchUrlCPC ="http://10.41.32.2:8081/api";

	public final static String workBenchLoginUrlCPC ="http://10.41.32.2:8081/api/login";






	public final static Integer workBenchDataTypeBool = 11;

	public final static Integer yearNo = 2018;




//	public final static String filePathServer =  "/Users/yangyuhuan/Desktop/DAUpload/";//upload
//
//	public final static String folderServer =  "/Users/yangyuhuan/Desktop/DADownload/";	//download


	public final static String filePathServer =  "C:/Users/wjin/Desktop/DAUpload/";  //upload server

	public final static String folderServer =  "C:/Users/wjin/Desktop/DADownload/";	//download server


	//FOR GENERAL MAPPER NAME FINAL STRING
	public  final static   String  CastingCPCGeneralPvFurnaceChamberCurveName ="com.casting.mapper.mybatis.CastingCPCGeneralPvFurnaceChamberCurveMapper.";

	public final static   String  CastingCPCGeneralShiftName ="com.casting.mapper.mybatis.CastingCPCGeneralShiftMapper.";

	public final static   String  CastingCPCGeneralOEEDataTemporaryName ="com.casting.mapper.mybatis.CastingCPCGeneralOEEDataTemporaryMapper.";

	public final static   String  CastingCPCGeneralOEEDataName ="com.casting.mapper.mybatis.CastingCPCGeneralOEEDataMapper.";



	//FOR GENERAL MAPPER NAME FINAL STRING  PRODUCTION TEM
	public  final static   String  GeneralProductionTemporaryName ="com.project.mapper.mybatis.GeneralProductionTemporaryMapper.";





	public static  final  String  GeneralOEEDataName ="com.project.mapper.mybatis.GeneralOEEDataMapper.";

	public static  final  String  GeneralPQDataName ="com.project.mapper.mybatis.GeneralPQDataMapper.";


	public static  final  String  GeneralShiftName ="com.project.mapper.mybatis.GeneralShiftMapper.";


	public static  final  String  GeneralOEEDataTemporaryName ="com.project.mapper.mybatis.GeneralOEEDataTemporaryMapper.";


	public static  final  String   GeneralTraceabilityDataName ="com.project.mapper.mybatis.GeneralTraceabilityDataMapper.";








	//Down time code explanation
	public static final Map<String, String> CODEEXPLANATION = new HashMap<String, String>();
	static{
		CODEEXPLANATION.put("SB","Lunch/Break/Clean/Start");
		CODEEXPLANATION.put("SM","Preventive Maintenance");
		CODEEXPLANATION.put("SC","Engineering/Change over");
		CODEEXPLANATION.put("ST","Training/Meeting");
		CODEEXPLANATION.put("SO","Other scheduled down");
		CODEEXPLANATION.put("QD","Dimensional problems");
		CODEEXPLANATION.put("QC","Components/Sorting");
		CODEEXPLANATION.put("MO","Operator");
		CODEEXPLANATION.put("MP","APC");
		CODEEXPLANATION.put("MT","ATC");
		CODEEXPLANATION.put("MF","Fixture");
		CODEEXPLANATION.put("MS","Spindle");
		CODEEXPLANATION.put("MH","Hydraulic");
		CODEEXPLANATION.put("MC","Coolant");
		CODEEXPLANATION.put("ME","Electrical");
		CODEEXPLANATION.put("MM","Mechanical");
		CODEEXPLANATION.put("MR","Robot");
		CODEEXPLANATION.put("MI","Miscellaneous");
		CODEEXPLANATION.put("RC","Lack of casting/comp.");
		CODEEXPLANATION.put("RO","Lack of operator");
		CODEEXPLANATION.put("TC","Scheduled tool change");
		CODEEXPLANATION.put("TB","Broken tool");
		CODEEXPLANATION.put("TW","Wrong set up");
		CODEEXPLANATION.put("TN","No back up");
		CODEEXPLANATION.put("TM","Miscellaneous");
		CODEEXPLANATION.put("NO EXPLANATION","NE");

	}




	public final static Integer beforeDownTimeCalculation = 1;

	public final static Integer afterDownTimeCalculation = 3;

	public final static Integer explainedDownTimeCalculation = 5;











}
