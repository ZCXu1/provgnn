package com.xzc.provgnn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzc.provgnn.entity.Similarity;
import com.xzc.provgnn.mapper.SimilarityMapper;
import com.xzc.provgnn.service.SimilarityService;
import org.springframework.stereotype.Service;

@Service
public class SimilarityServiceImpl extends ServiceImpl<SimilarityMapper, Similarity> implements SimilarityService {
}
