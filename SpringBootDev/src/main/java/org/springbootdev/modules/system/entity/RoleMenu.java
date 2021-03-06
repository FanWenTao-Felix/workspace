
package org.springbootdev.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类
 *
 * @author zhaobohao
 */
@Data
@TableName("mk_role_menu")
@ApiModel(value = "RoleMenu对象", description = "RoleMenu对象")
public class RoleMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	@TableId(value = "id", type = IdType.NONE)
	@JsonSerialize(using= ToStringSerializer.class)
	private Long id;

	/**
	 * 菜单id
	 */
	@ApiModelProperty(value = "菜单id")
	private Long menuId;

	/**
	 * 角色id
	 */
	@ApiModelProperty(value = "角色id")
	private Long roleId;


}
