package com.system.domain.model.output;

import com.system.domain.entity.Menu;

public class MenuOutput extends Menu {

    //列表是否展开
    private boolean expanded = true;

    private boolean isLeaf = false;

    private String id;

    private boolean loaded = true;
    private String stateName;
    private String isShowName;

    public String getId() {
        return this.getMenuId();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStateName() {
        if(this.getState()!=null)
        {
            switch (this.getState())
            {
                case 0:
                    stateName="有效";
                    break;
                case 1:
                    stateName="无效";
                    break;
                default:
                    stateName="";
                    break;
            }
        }
        return stateName;
    }
    public void setStateName()
    {
        this.stateName = stateName == null ? null : stateName.trim();
    }
    public String getIsShowName() {
        if(this.getState()!=null)
        {
            switch (this.getState())
            {
                case 0:
                    isShowName="展示";
                    break;
                case 1:
                    isShowName="不展示";
                    break;
                default:
                    isShowName="";
                    break;
            }
        }
        return isShowName;
    }
    public void setIsShowName()
    {
        this.isShowName = isShowName == null ? null : isShowName.trim();
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean getIsLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    @Override
    public String toString() {
        return super.getMenuId()+ "," + super.getParentId();
    }
}
