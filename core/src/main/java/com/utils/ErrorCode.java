package com.utils;

public class ErrorCode {
	
	public enum COMMONERRORCODE{
		COMMON_ERROR_INSERT(49991,"插入出错！"),
		COMMON_ERROR_UPDATE(49992,"更新出错！"),
		COMMON_ERROR_DELETE(49993,"删除出错！"),
		COMMON_ERROR_DATA(49999, "错误数据");
		
		private Integer index;
        private String name;

        COMMONERRORCODE(Integer index, String name) {
            this.index = index;
            this.name = name;
        }

        public Integer getIndex() {
			return index;
		}
		public String getName() {
            return name;
        }
	}
	
	public enum BASEERRORCODE{
		
		BASE_EXIST_ACCOUNT(42000,"帐号名已存在！");
		
		
		private Integer index;
        private String name;

        BASEERRORCODE(Integer index, String name) {
            this.index = index;
            this.name = name;
        }

        public Integer getIndex() {
			return index;
		}
		public String getName() {
            return name;
        }
	}
}
