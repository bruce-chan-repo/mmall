package com.imock.mmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imock.mmall.entity.Product;
import com.imock.mmall.mapper.ProductMapper;
import com.imock.mmall.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.rmi.PortableRemoteObject;
import java.util.List;

/**
 * TODO
 *
 * @author: Chen Kj
 * @date: 2018/8/21 16:48
 * @version: 1.0
 */
@Service
@CacheConfig(cacheNames = {"product"})
public class ProductServiceImpl implements IProductService {
    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;

    @Override
    @Cacheable(key = "#pageNum + '_' + #pageSize")
    public PageInfo<Product> getList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<Product> products = productMapper.selectList();
        PageInfo<Product> pageInfo = new PageInfo<>(products);

        return pageInfo;
    }

    @Override
    @Cacheable(key = "#a0", unless = "#result == null")
    public Product detail(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }
}
