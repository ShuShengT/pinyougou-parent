package com.pinyougou.manager.controller;

import java.util.List;

import com.alibaba.dubbo.container.page.Page;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.*;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {
	
	@Reference
	private BrandService brandService;
	
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		return brandService.findAll();
	}

	@RequestMapping("/findPage")
	public PageResult findPage(@RequestParam (defaultValue = "1")int pageNum,@RequestParam (defaultValue = "10")int pageSize){
		return brandService.findByPage (pageNum,pageSize);
	}

	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Result add(@RequestBody TbBrand brand){
		try{
			brandService.save (brand);
			return new Result (true,"添加成功");
		}catch (Exception e){
			return new Result (false,"添加失败");
		}
	}
}
