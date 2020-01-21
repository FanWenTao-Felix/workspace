package com.mallplus.common.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体父类
 * @author mall
 */
@Setter
@Getter
public class SuperEntity<T extends Model> extends Model<T> {
    /**
     * 主键ID
     */
    @TableId
    private Long id;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
