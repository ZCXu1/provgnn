package com.xzc.provgnn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("test5")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entity {
    @TableId
    private int entityId;
    @TableField("entity_name")
    private String entityName;
}
