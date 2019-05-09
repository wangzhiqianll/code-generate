package com.aek.shop.api.service;

import com.aek.shop.api.vo.ShopScrollInfoVO;
import com.aek.shop.api.bo.ShopScrollInfoBO;
import com.aek.shop.api.vo.ShopScrollInfoPageVO;
import com.aek.shop.api.bo.ShopScrollInfoPageQueryBO;
import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/** 
 * @Description 店铺轮播
 * @author ansen.zhu
 * @date 2019-05-05 14:03:53
 */
@FeignClient(name = "shop-service")
public interface ShopScrollInfoApiService {

    @RequestMapping(value = "/shop/scroll/get", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
	ShopScrollInfoVO get(@RequestBody final Long id);

    @RequestMapping(value = "/shop/scroll/list", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
	List<ShopScrollInfoVO> list(@RequestBody final Map<String, Object> map);
	
    @RequestMapping(value = "/shop/scroll/page", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ShopScrollInfoPageVO page(@RequestBody final ShopScrollInfoPageQueryBO shopScrollInfoPageQueryBO);

    @RequestMapping(value = "/shop/scroll/count", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
	int count(@RequestBody final Map<String, Object> map);

    @RequestMapping(value = "/shop/scroll/save", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
	int save(@RequestBody final ShopScrollInfoBO shopScrollInfoBO);
	
    @RequestMapping(value = "/shop/scroll/update", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
	int update(@RequestBody final ShopScrollInfoBO shopScrollInfoBO);
	
    @RequestMapping(value = "/shop/scroll/delete", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
	int remove(@RequestBody final Long id);
	
    @RequestMapping(value = "/shop/scroll/batch/delete", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
	int batchRemove(@RequestBody final Long[] ids);
}
