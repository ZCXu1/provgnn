package com.xzc.provgnn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzc.provgnn.entity.Entity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface EntityMapper extends BaseMapper<Entity> {

    @Select("SELECT * FROM test5 where entity_name = #{name}")
    Entity selectByName(@Param("name") String name);

}
