
package org.springclouddev.system.feign;

import lombok.AllArgsConstructor;
import org.springclouddev.system.entity.Dept;
import org.springclouddev.system.entity.Role;
import org.springclouddev.system.service.IDeptService;
import org.springclouddev.system.service.IMenuService;
import org.springclouddev.system.service.IPostService;
import org.springclouddev.system.service.IRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 系统服务Feign实现类
 *
 * @author zhaobohao
 */
@ApiIgnore
@RestController
@AllArgsConstructor
public class SysClient implements ISysClient {

	private IDeptService deptService;

	private IPostService postService;

	private IRoleService roleService;

	@Override
	@GetMapping(API_PREFIX + "/getDept")
	public Dept getDept(Long id) {
		return deptService.getById(id);
	}

	@Override
	@GetMapping(API_PREFIX + "/getDeptName")
	public String getDeptName(Long id) {
		return deptService.getById(id).getDeptName();
	}

	@Override
	public String getDeptIds(String tenantId, String deptNames) {
		return deptService.getDeptIds(tenantId, deptNames);
	}

	@Override
	public List<String> getDeptNames(String deptIds) {
		return deptService.getDeptNames(deptIds);
	}

	@Override
	public String getPostIds(String tenantId, String postNames) {
		return postService.getPostIds(tenantId, postNames);
	}

	@Override
	public List<String> getPostNames(String postIds) {
		return postService.getPostNames(postIds);
	}

	@Override
	@GetMapping(API_PREFIX + "/getRole")
	public Role getRole(Long id) {
		return roleService.getById(id);
	}

	@Override
	public List<String> getPermission(String id) {
		return null;
	}

	@Override
	public String getRoleIds(String tenantId, String roleNames) {
		return roleService.getRoleIds(tenantId, roleNames);
	}

	@Override
	@GetMapping(API_PREFIX + "/getRoleName")
	public String getRoleName(Long id) {
		return roleService.getById(id).getRoleName();
	}

	@Override
	public List<String> getRoleNames(String roleIds) {
		return roleService.getRoleNames(roleIds);
	}

	@Override
	@GetMapping(API_PREFIX + "/getRoleAlias")
	public String getRoleAlias(Long id) {
		return roleService.getById(id).getRoleAlias();
	}
}