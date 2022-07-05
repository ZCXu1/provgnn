package com.xzc.provgnn.entity;

/**
 * @Author: ZCXu1
 * @Date: 2022/7/5 20:33
 * @Version: 1.0.0
 * @Description:
 */
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("test5_vec")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vector {
    @TableId
    private int entityId;
    @TableField("vector")
    // feature vector of the entity
    private String vector;
}
