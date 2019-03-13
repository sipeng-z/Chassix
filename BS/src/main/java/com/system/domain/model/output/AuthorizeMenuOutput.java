package com.system.domain.model.output;

import java.util.List;

public class AuthorizeMenuOutput {
	
	private String menuid;

	private String parentid;

	private String name;

	private String link;

	private String module;

	private String style;

	private String icon;

	private String target;

	private Integer layer;

	private List<ZtreeInfo>  childNodeList=null;
	
	
	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Integer getLayer() {
		return layer;
	}

	public void setLayer(Integer layer) {
		this.layer = layer;
	}

	public List<ZtreeInfo> getChildNodeList() {
		return childNodeList;
	}

	public void setChildNodeList(List<ZtreeInfo> childNodeList) {
		this.childNodeList = childNodeList;
	}
	

}
