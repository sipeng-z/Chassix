package com.utils;

public class CommonConstants {
	public interface OSS {
//		public static final String bucketName = "";
//		public static final String accessKeyId = "";
//		public static final String accessKeySecret = "";
//		public static final String endpoint = "";
//		public static final String host = "";

		public static final int MAX_KEYS = 1000;// 获取列表的数量个数 如果不指定个数 默认是100
												// 最大不能超过1000 有超过1000的需求 需要分页来处理
	}

	public interface PERMISSIONTYPE{
		public static final Integer ROLETYPE = 1;//角色权限type

		public static final Integer DEVICETYPE = 2;//设备权限type
	}

	public interface IsValid{
		public static final Integer ISVALID = 0;//默认有效
	}

	public interface DataType{
		public static final Integer System_DataType = 1;//系统数据类型
	}

	public interface IsFingerprint{
		public static final Integer IsFingerprint_no = 0;//系统数据类型
	}
	public interface Privilege{
		public static final Integer Privilege_no = 0;//系统数据类型
	}

	public interface Enabled{
		public static final Integer Enabled_no = 1;//系统数据类型
	}

	public interface JOBTASKTYPE{
		public static final Integer ATTENDANCETYPE = 1;
	}
	public interface HTTPURL{
		public static final String url = "http://";
	}
	
	//分页
		public interface PAGE {
			public static final Integer pagesize = 10;
		}
		
		public interface COMPANY{
			
			public static final String STATUS_NORMAL = "状态正常";
		}
	    public interface EX{
			public static final String EXCEPTION = "Request Error!";
	    }


	public interface CONTROLLERNAME {
		public static final Integer ADD = 1;
		public static final Integer UPDATE = 2;
		public static final Integer DELETE = 3;
	}



}
