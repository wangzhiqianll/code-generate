package com.aek.mspp.web.controller;

import com.aek.shop.api.bo.ShopScrollInfoBO;
import com.aek.shop.api.bo.ShopScrollInfoPageQueryBO;
import com.aek.shop.api.service.ShopScrollInfoApiService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.aek.core.web.controller.BaseController;
import com.aek.core.web.vo.ResultModel;

/** 
 * @Description 店铺轮播
 * @author ansen.zhu
 * @date 2019-05-05 14:03:53
 */
@Api(tags = {"店铺轮播"})
@RestController
@RequestMapping(value = "/aek-mspp")
public class ShopScrollInfoController extends BaseController{

	@Autowired
	private  ShopScrollInfoApiService shopScrollInfoApiService;
	
    @RequestMapping(value = "/shop/scroll/get", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "获取店铺轮播", httpMethod = "POST")
	public ResultModel get(@RequestBody final Long id){
		return ResultModel.ok(this.shopScrollInfoApiService.get(id));
	}

    @RequestMapping(value = "/shop/scroll/list", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "获取店铺轮播列表", httpMethod = "POST")
	public ResultModel list(@RequestBody final Map<String, Object> map){
		return ResultModel.ok(this.shopScrollInfoApiService.list(map));
	}
	
	@RequestMapping(value = "/shop/scroll/page", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "分页获取店铺轮播列表", httpMethod = "POST")
    public ResultModel page(@RequestBody final ShopScrollInfoPageQueryBO shopScrollInfoPageQueryBO) {
        shopScrollInfoPageQueryBO.setSupplierOrgId(this.getCurrentOrgId());
        return ResultModel.ok(this.shopScrollInfoApiService.page(shopScrollInfoPageQueryBO));
    }

    @RequestMapping(value = "/shop/scroll/count", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "计数店铺轮播", httpMethod = "POST")
	public ResultModel count(@RequestBody final Map<String, Object> map){
		return ResultModel.ok(this.shopScrollInfoApiService.count(map));
	}

    @RequestMapping(value = "/shop/scroll/save", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "新增店铺轮播", httpMethod = "POST")
	public ResultModel save(@RequestBody final ShopScrollInfoBO shopScrollInfoBO){
		return ResultModel.ok(this.shopScrollInfoApiService.save(shopScrollInfoBO));
	}
	
    @RequestMapping(value = "/shop/scroll/update", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "更新店铺轮播", httpMethod = "POST")
	public ResultModel update(@RequestBody final ShopScrollInfoBO shopScrollInfoBO){
		return ResultModel.ok(this.shopScrollInfoApiService.update(shopScrollInfoBO));
	}
	
    @RequestMapping(value = "/shop/scroll/delete", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "删除店铺轮播", httpMethod = "POST")
	public ResultModel remove(@RequestBody final Long id){
		return ResultModel.ok(this.shopScrollInfoApiService.remove(id));
	}
	
    @RequestMapping(value = "/shop/scroll/batch/delete", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "批量删除店铺轮播", httpMethod = "POST")
	public ResultModel batchRemove(@RequestBody final Long[] ids){
		return ResultModel.ok(this.shopScrollInfoApiService.batchRemove(ids));
	}
}
