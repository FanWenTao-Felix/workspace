
package org.springclouddev.system.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springclouddev.system.entity.RoleMenu;

/**
 * 数据传输对象实体类
 *
 * @author firewan
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleMenuDTO extends RoleMenu {
	private static final long serialVersionUID = 1L;

}