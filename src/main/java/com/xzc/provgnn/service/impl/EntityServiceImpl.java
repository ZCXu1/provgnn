package com.xzc.provgnn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzc.provgnn.entity.Entity;
import com.xzc.provgnn.mapper.EntityMapper;
import com.xzc.provgnn.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityServiceImpl extends ServiceImpl<EntityMapper, Entity> implements EntityService {
    @Autowired
    private  EntityMapper entityMapper;

    @Override
    public Entity selectByName(String name) {
        return entityMapper.selectByName(name);
    }
}
