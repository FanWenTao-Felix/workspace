

package com.spring.demo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author geekidea
 * @date 2018-11-08
 */
@ApiModel("主键状态VO")
public class IdStatusParam implements Serializable {
    private static final long serialVersionUID = -7581307955242965701L;

    @ApiModelProperty("主键ID")
    private String id;

    @ApiModelProperty("状态,1:启用 0:禁用")
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "IdStatusVo{" +
                "id='" + id + '\'' +
                ", status=" + status +
                '}';
    }
}
