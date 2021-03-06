package com.spring.web.dao.entity;

import com.spring.web.dao.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * IP地址
 * </p>
 *
 * @author zhaobohao
 * @since 2019-08-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="Ip对象", description="IP地址")
public class Ip extends SuperEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ip开始地址")
    private String ipStart;

    @ApiModelProperty(value = "ip结束地址")
    private String ipEnd;

    @ApiModelProperty(value = "区域")
    private String area;

    @ApiModelProperty(value = "运营商")
    private String operator;



    @ApiModelProperty(value = "ip开始地址数字")
    private Long ipStartNum;

    @ApiModelProperty(value = "ip结束地址数字")
    private Long ipEndNum;

}
