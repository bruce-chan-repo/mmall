package com.imock.mmall.web;

import com.github.pagehelper.PageInfo;
import com.imock.mmall.entity.Product;
import com.imock.mmall.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品控制层.
 * @author: Chen Kj
 * @date: 2018/8/21 16:53
 * @version: 1.0
 */
@Api(value = "API - ProductController", description = "产品接口")
@RestController
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IProductService productService;


    @ApiOperation(value = "获取产品的分页信息", notes = "如果分页依据没有传递，将默认是第1页，每页5条显示")
    @GetMapping("/api/v1/products")
    public PageInfo<Product> getList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        PageInfo<Product> pageInfo = productService.getList(pageNum, pageSize);
        return pageInfo;
    }

    @ApiOperation(value = "获取产品的详请", notes = "获取产品的详情")
    @GetMapping("/api/v1/products/{id}")
    public Product detail(@PathVariable("id") Integer id) {
        Product detail = productService.detail(id);
        return detail;
    }
}
