package com.xzc.provgnn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("test5_sim")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Similarity {
    @TableId
    private int entityId;
    @TableField("similarity")
    private String similarity;
}
