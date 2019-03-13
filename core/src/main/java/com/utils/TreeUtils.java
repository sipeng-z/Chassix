package com.utils;


import java.util.ArrayList;
import java.util.List;


public class TreeUtils {
	/**
	 * 树结构排序的公共方法
	 * 非递归方法有误
	 * @param rootId
	 * @param list
	 * @return
	 */
	public static <T> List<T> tree(String rootId,List<T> list){
		List<T> dataList = new ArrayList<T>();
		for(T t : list) {
			if( getId(t.toString())[1].equals(rootId) ) {
				dataList.add(t);
			}
		}
		for(int j = 0; j<dataList.size(); j++) {
			T t = dataList.get(j);
			int k = 1;
			for(int i = 0; i<list.size(); i++) {
				if(getId(t.toString())[0].equals(getId(list.get(i).toString())[1])) {

					dataList.add(j+k++, list.get(i));
				}
			}
		}
		return dataList;
	}

	/**
	 * 解析实体类的toString 
	 * 定义下表0的为主键
	 * 下标为1的为pId
	 * @param idlist
	 * @return
	 */
	public static String[] getId(String idlist) {
		String[] strs = idlist.split(",");
		return strs;
	}
}
