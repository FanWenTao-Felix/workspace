
package org.springbootdev.modules.system.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springbootdev.modules.system.entity.Dict;

/**
 * 数据传输对象实体类
 *
 * @author merryChen
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DictDTO extends Dict {
	private static final long serialVersionUID = 1L;

}