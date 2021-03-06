
package org.springbootdev.modules.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.springbootdev.core.mp.base.SuperMapper;
import org.springbootdev.modules.system.entity.User;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author zhaobohao
 */

@Mapper
public interface UserMapper extends SuperMapper<User> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param user
	 * @return
	 */
	List<User> selectUserPage(IPage page, User user);

	/**
	 * 获取用户
	 *
	 * @param tenantId
	 * @param account
	 * @param password
	 * @return
	 */
	User getUser(String tenantId, String account, String password);

	/**
	 * 获取角色名
	 *
	 * @param ids
	 * @return
	 */
	List<String> getRoleName(String[] ids);

	/**
	 * 获取角色别名
	 *
	 * @param ids
	 * @return
	 */
	List<String> getRoleAlias(String[] ids);

	/**
	 * 获取部门名
	 *
	 * @param ids
	 * @return
	 */
	List<String> getDeptName(String[] ids);

}
