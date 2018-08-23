package com.imock.mmall.service;

import com.github.pagehelper.PageInfo;
import com.imock.mmall.entity.Product;

/**
 * 产品业务接口
 * @author: Chen Kj
 * @date: 2018/6/29 9:22
 * @version: 1.0
 */
public interface IProductService {

    PageInfo<Product> getList(Integer pageNum, Integer pageSize);

    Product detail(Integer id);
}
