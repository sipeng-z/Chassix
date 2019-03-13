package com.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 描述：基层树形结构实体类
 */
public abstract class BaseTreeObj<E, ID extends Serializable> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private boolean hasChildren=false;
	private boolean complete=false;
	private boolean isexpand=false;
	private List<E> ChildNodes = new ArrayList<E>();



	public abstract ID getPkId();

	public abstract void setPkId(ID id);

	public abstract void setParentid(ID parentid);

	public abstract ID getParentid();
	
	public abstract String getText();

	public abstract String getValue();
	
	public List<E> getChildNodes() {
		return ChildNodes;
	}

	public void setChildNodes(List<E> _ChildNodes) {
		ChildNodes = _ChildNodes;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	public boolean isComplete() {
		return true;
	}

	public boolean isIsexpand() {
		return true;
	}
	
	
}