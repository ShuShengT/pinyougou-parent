package com.pinyougou.sellergoods.service.impl;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;

	@Override
	public List<TbBrand> findAll() {
		// TODO Auto-generated method stub
		return brandMapper.selectByExample(null);
	}

	@Override
	@Transactional
	public PageResult findByPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage (pageNum,pageSize);
		Page<TbBrand> page = (Page<TbBrand>)brandMapper.selectByExample (null);
		return new PageResult(page.getTotal (),page.getResult ());
	}

	@Override
	public void save(TbBrand brand) {
		// TODO Auto-generated method stub
		brandMapper.insert (brand);
	}

	@Override
	public TbBrand findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TbBrand brand) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long[] ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Map> selectOptionList() {
		// TODO Auto-generated method stub
		return null;
	}

}
