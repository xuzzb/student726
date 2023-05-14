package com.dcits.service.impl;

import com.dcits.dao.OrderDao;
import com.dcits.entity.OrderEntity;
import com.dcits.service.OrderService;
import com.dcits.utils.PageUtils;
import com.dcits.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                new QueryWrapper<OrderEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<OrderEntity> listByUserId(Integer userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",userId);
        return baseMapper.selectList(queryWrapper);
    }

}