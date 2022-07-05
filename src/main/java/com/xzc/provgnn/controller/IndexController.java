package com.xzc.provgnn.controller;

import com.alibaba.fastjson.JSON;
import com.xzc.provgnn.dto.SearchEntity;
import com.xzc.provgnn.dto.SearchEvent;
import com.xzc.provgnn.entity.Entity;
import com.xzc.provgnn.entity.Similarity;
import com.xzc.provgnn.entity.Vector;
import com.xzc.provgnn.result.Code;
import com.xzc.provgnn.result.Result;
import com.xzc.provgnn.service.EntityService;
import com.xzc.provgnn.service.SimilarityService;
import com.xzc.provgnn.service.VectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private VectorService vectorService;

    private final double threshold = 0.5;

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
    @RequestMapping(value = "/getjudge", method = RequestMethod.POST)
    public Result<Map<String,String>> getJudgment(@RequestBody SearchEvent dto){
        String subjectName = dto.getSubject();
        String objectName = dto.object;
        Entity subject = entityService.selectByName(subjectName);
        Entity object = entityService.selectByName(objectName);
        if (subject != null && object != null){
            int subjectId = subject.getEntityId();
            int objectId = object.getEntityId();
            String subjectVectorString = vectorService.getById(subjectId).getVector();
            String objectVectorString = vectorService.getById(objectId).getVector();
            List<Double> subjectVector = JSON.parseArray(subjectVectorString,Double.class);
            List<Double> objectVector = JSON.parseArray(objectVectorString,Double.class);
            double result = 0.0;
            int n = subjectVector.size();
            for (int i = 0; i < n; i++) {
                result += (subjectVector.get(i)*objectVector.get(i));
            }
            Map<String,String> map = new HashMap<>();
            if (result <= threshold){
                map.put("result","benign");
            }else{
                map.put("result","malicious");
            }
            return new Result<>(Code.SUCCESS.getCode(), map);
        }
        return new Result<>(Code.FAILED.getCode(), null);
    }



}
