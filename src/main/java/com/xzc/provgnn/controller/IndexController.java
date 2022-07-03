package com.xzc.provgnn.controller;

import com.alibaba.fastjson.JSON;
import com.xzc.provgnn.dto.SearchEntity;
import com.xzc.provgnn.entity.Entity;
import com.xzc.provgnn.entity.Similarity;
import com.xzc.provgnn.result.Code;
import com.xzc.provgnn.result.Result;
import com.xzc.provgnn.service.EntityService;
import com.xzc.provgnn.service.SimilarityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZCXu1
 * @Date: 2022/7/3 15:30
 * @Version: 1.0.0
 * @Description:
 */

@RestController
public class IndexController {

    @Autowired
    private EntityService entityService;

    @Autowired
    private SimilarityService similarityService;

    @RequestMapping(value = "/getsim", method = RequestMethod.POST)
    public Result<Map<String,String>> getSimilarEntities(@RequestBody SearchEntity dto){
        String searchEntityName = dto.getEntityName();
        Entity searchEntity = entityService.selectByName(searchEntityName);
        if (searchEntity != null){
            int searchEntityId = searchEntity.getEntityId();
            Similarity similarity = similarityService.getById(searchEntityId);
            String simListString = similarity.getSimilarity();
            List<Integer> simList = JSON.parseArray(simListString,Integer.class);
            /**
             * get three most similar entities
             */
            Map<String,String> map = new HashMap<>();
            map.put("first",entityService.getById(simList.get(1)).getEntityName());
            map.put("second",entityService.getById(simList.get(2)).getEntityName());
            map.put("third",entityService.getById(simList.get(3)).getEntityName());

            return new Result<>(Code.SUCCESS.getCode(), map);
        }

        return new Result<>(Code.FAILED.getCode(), null);
    }

}
