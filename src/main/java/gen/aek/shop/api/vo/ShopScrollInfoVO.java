package com.aek.shop.api.vo;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/** 
 * @Description 店铺轮播
 * @author ansen.zhu
 * @date 2019-05-05 14:03:53
 */
public class ShopScrollInfoVO {
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
    	this.scrollId = scrollId;
    }
    public String getShopId(){
    	return shopId;
    }
    
    public void setShopId(String shopId){
    	this.shopId = shopId;
    }
    public String getOrgId(){
    	return orgId;
    }
    
    public void setOrgId(String orgId){
    	this.orgId = orgId;
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
    	this.scrollUrl = scrollUrl;
    }
    public String getScrollJumpUrl(){
    	return scrollJumpUrl;
    }
    
    public void setScrollJumpUrl(String scrollJumpUrl){
    	this.scrollJumpUrl = scrollJumpUrl;
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
    	this.addBy = addBy;
    }
    public String getAddName(){
    	return addName;
    }
    
    public void setAddName(String addName){
    	this.addName = addName;
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
    	this.lastEditBy = lastEditBy;
    }
    public String getLastEditName(){
    	return lastEditName;
    }
    
    public void setLastEditName(String lastEditName){
    	this.lastEditName = lastEditName;
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
}
