package com.xzc.provgnn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzc.provgnn.entity.Entity;

public interface EntityService extends IService<Entity> {
    Entity selectByName(String name);
}
