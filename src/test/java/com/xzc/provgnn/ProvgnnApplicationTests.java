package com.xzc.provgnn;

import com.xzc.provgnn.entity.Entity;
import com.xzc.provgnn.entity.Similarity;
import com.xzc.provgnn.mapper.EntityMapper;
import com.xzc.provgnn.result.Code;
import com.xzc.provgnn.result.Result;
import com.xzc.provgnn.service.EntityService;
import com.xzc.provgnn.service.SimilarityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProvgnnApplicationTests {

    @Autowired
    private EntityService entityService;

    @Autowired
    private SimilarityService similarityService;

    @Test
    void contextLoads() {
        String searchEntityName = "/etc/passwd";
        Entity searchEntity = entityService.selectByName(searchEntityName);
        int searchEntityId = searchEntity.getEntityId();
        Similarity similarity = similarityService.getById(searchEntityId);
        System.out.println(similarity);
    }

}
