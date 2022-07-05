package com.xzc.provgnn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzc.provgnn.entity.Vector;
import com.xzc.provgnn.mapper.VectorMapper;
import com.xzc.provgnn.service.VectorService;
import org.springframework.stereotype.Service;

/**
 * @Author: ZCXu1
 * @Date: 2022/7/5 20:35
 * @Version: 1.0.0
 * @Description:
 */
@Service
public class VectorServiceImpl extends ServiceImpl<VectorMapper, Vector> implements VectorService {
}
