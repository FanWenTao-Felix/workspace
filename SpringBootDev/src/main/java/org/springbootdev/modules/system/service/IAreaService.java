
package org.springbootdev.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springbootdev.core.mp.base.BaseService;
import org.springbootdev.modules.system.entity.Area;
import org.springbootdev.modules.system.vo.AreaVO;

import java.util.List;

/**
 * 行政区划 服务类
 *
 * @author zhaobohao
 * @since 2019-12-23
 */
public interface IAreaService extends BaseService<Area> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param area
	 * @return
	 */
	IPage<AreaVO> selectAreaPage(IPage<AreaVO> page, AreaVO area);
	/**
	 * 树形结构
	 *
	 * @return
	 */
	List<AreaVO> tree(String parentId);
}
