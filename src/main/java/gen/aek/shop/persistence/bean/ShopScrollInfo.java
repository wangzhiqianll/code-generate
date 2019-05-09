package com.aek.shop.persistence.bean;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.aek.core.persistence.bean.AbstractBean;
import com.aek.core.util.UUIDUtil;

/** 
 * @Description 店铺轮播
 * @author ansen.zhu
 * @date 2019-05-05 14:03:53
 */
public class ShopScrollInfo extends AbstractBean {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String scrollId;
    private String shopId;
    private String orgId;
    private Integer scrollIndex;
    private String scrollUrl;
    private String scrollJumpUrl;
    private Integer scrollStatus;
    private Date startTime;
    private Date expireTime;
    private String addBy;
    private String addName;
    private Date addTime;
    private String lastEditBy;
    private String lastEditName;
    private Date lastEditTime;
    private Integer delFlag;

	@Override
    public void settingCreatingDefaultValue(final String addBy, final String addName) {
        super.settingCreatingDefaultValue(addBy, addName);
        scrollId = UUIDUtil.get32UpperCaseUUID();
    }

    public Long getId(){
    	return id;
    }
    
    
    public void setId(Long id){
    	    	this.id = id;
    	    }
    public String getScrollId(){
    	return scrollId;
    }
    
    
    public void setScrollId(String scrollId){
    	    	this.scrollId = scrollId == null ? null : scrollId.trim();
    	    }
    public String getShopId(){
    	return shopId;
    }
    
    
    public void setShopId(String shopId){
    	    	this.shopId = shopId == null ? null : shopId.trim();
    	    }
    public String getOrgId(){
    	return orgId;
    }
    
    
    public void setOrgId(String orgId){
    	    	this.orgId = orgId == null ? null : orgId.trim();
    	    }
    public Integer getScrollIndex(){
    	return scrollIndex;
    }
    
    
    public void setScrollIndex(Integer scrollIndex){
    	    	this.scrollIndex = scrollIndex;
    	    }
    public String getScrollUrl(){
    	return scrollUrl;
    }
    
    
    public void setScrollUrl(String scrollUrl){
    	    	this.scrollUrl = scrollUrl == null ? null : scrollUrl.trim();
    	    }
    public String getScrollJumpUrl(){
    	return scrollJumpUrl;
    }
    
    
    public void setScrollJumpUrl(String scrollJumpUrl){
    	    	this.scrollJumpUrl = scrollJumpUrl == null ? null : scrollJumpUrl.trim();
    	    }
    public Integer getScrollStatus(){
    	return scrollStatus;
    }
    
    
    public void setScrollStatus(Integer scrollStatus){
    	    	this.scrollStatus = scrollStatus;
    	    }
    public Date getStartTime(){
    	return startTime;
    }
    
    
    public void setStartTime(Date startTime){
    	    	this.startTime = startTime;
    	    }
    public Date getExpireTime(){
    	return expireTime;
    }
    
    
    public void setExpireTime(Date expireTime){
    	    	this.expireTime = expireTime;
    	    }
    public String getAddBy(){
    	return addBy;
    }
    
    
    public void setAddBy(String addBy){
    	    	this.addBy = addBy == null ? null : addBy.trim();
    	    }
    public String getAddName(){
    	return addName;
    }
    
    
    public void setAddName(String addName){
    	    	this.addName = addName == null ? null : addName.trim();
    	    }
    public Date getAddTime(){
    	return addTime;
    }
    
    
    public void setAddTime(Date addTime){
    	    	this.addTime = addTime;
    	    }
    public String getLastEditBy(){
    	return lastEditBy;
    }
    
    
    public void setLastEditBy(String lastEditBy){
    	    	this.lastEditBy = lastEditBy == null ? null : lastEditBy.trim();
    	    }
    public String getLastEditName(){
    	return lastEditName;
    }
    
    
    public void setLastEditName(String lastEditName){
    	    	this.lastEditName = lastEditName == null ? null : lastEditName.trim();
    	    }
    public Date getLastEditTime(){
    	return lastEditTime;
    }
    
    
    public void setLastEditTime(Date lastEditTime){
    	    	this.lastEditTime = lastEditTime;
    	    }
    public Integer getDelFlag(){
    	return delFlag;
    }
    
    
    public void setDelFlag(Integer delFlag){
    	    	this.delFlag = delFlag;
    	    }
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(",id").append(id);
        sb.append(",scrollId").append(scrollId);
        sb.append(",shopId").append(shopId);
        sb.append(",orgId").append(orgId);
        sb.append(",scrollIndex").append(scrollIndex);
        sb.append(",scrollUrl").append(scrollUrl);
        sb.append(",scrollJumpUrl").append(scrollJumpUrl);
        sb.append(",scrollStatus").append(scrollStatus);
        sb.append(",startTime").append(startTime);
        sb.append(",expireTime").append(expireTime);
        sb.append(",addBy").append(addBy);
        sb.append(",addName").append(addName);
        sb.append(",addTime").append(addTime);
        sb.append(",lastEditBy").append(lastEditBy);
        sb.append(",lastEditName").append(lastEditName);
        sb.append(",lastEditTime").append(lastEditTime);
        sb.append(",delFlag").append(delFlag);
            sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
