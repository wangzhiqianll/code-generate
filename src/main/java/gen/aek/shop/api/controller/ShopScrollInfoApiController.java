package com.aek.shop.api.controller;

import com.aek.shop.api.vo.ShopScrollInfoVO;
import com.aek.shop.api.bo.ShopScrollInfoBO;
import com.aek.shop.api.vo.ShopScrollInfoPageVO;
import com.aek.shop.api.bo.ShopScrollInfoPageQueryBO;
import com.aek.shop.service.biz.ShopScrollInfoBizService;
import com.aek.shop.persistence.bean.ShopScrollInfo;
import com.aek.shop.api.service.ShopScrollInfoApiService;
import java.util.List;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.baomidou.mybatisplus.plugins.Page;

/** 
 * @Description 店铺轮播
 * @author ansen.zhu
 * @date 2019-05-05 14:03:53
 */
@Api(tags = {"店铺轮播"})
@RestController
public class ShopScrollInfoApiController implements ShopScrollInfoApiService{

	@Autowired
	private ShopScrollInfoBizService shopScrollInfoBizService;
	
	@Override
    @RequestMapping(value = "/shop/scroll/get", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "获取店铺轮播", httpMethod = "POST")
	public ShopScrollInfoVO get(@RequestBody final Long id){
	
		return this.shopScrollInfoBizService.get(id);
	}

	@Override
    @RequestMapping(value = "/shop/scroll/list", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "获取店铺轮播列表", httpMethod = "POST")
	public List<ShopScrollInfoVO> list(@RequestBody final Map<String, Object> map){
		return this.shopScrollInfoBizService.list(map);
	}
	
	@Override
	@RequestMapping(value = "/shop/scroll/page", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "分页获取店铺轮播列表", httpMethod = "POST")
    public ShopScrollInfoPageVO page(@RequestBody final ShopScrollInfoPageQueryBO shopScrollInfoPageQueryBO) {
        final Page<ShopScrollInfo> page = new Page<>(shopScrollInfoPageQueryBO.getCurrent(),shopScrollInfoPageQueryBO.getPageSize());
        return this.shopScrollInfoBizService.page(page, shopScrollInfoPageQueryBO);
    }

	@Override
    @RequestMapping(value = "/shop/scroll/count", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "计数店铺轮播", httpMethod = "POST")
	public int count(@RequestBody final Map<String, Object> map){
		return this.shopScrollInfoBizService.count(map);
	}

	@Override
    @RequestMapping(value = "/shop/scroll/save", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "新增店铺轮播", httpMethod = "POST")
	public int save(@RequestBody final ShopScrollInfoBO shopScrollInfoBO){
		return this.shopScrollInfoBizService.save(shopScrollInfoBO);
	}
	
	@Override
    @RequestMapping(value = "/shop/scroll/update", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "更新店铺轮播", httpMethod = "POST")
	public int update(@RequestBody final ShopScrollInfoBO shopScrollInfoBO){
		return this.shopScrollInfoBizService.update(shopScrollInfoBO);
	}
	
	@Override
    @RequestMapping(value = "/shop/scroll/delete", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "删除店铺轮播", httpMethod = "POST")
	public int remove(@RequestBody final Long id){
		return this.shopScrollInfoBizService.remove(id);
	}
	
	@Override
    @RequestMapping(value = "/shop/scroll/batch/delete", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "批量删除店铺轮播", httpMethod = "POST")
	public int batchRemove(@RequestBody final Long[] ids){
		return this.shopScrollInfoBizService.batchRemove(ids);
	}
}
