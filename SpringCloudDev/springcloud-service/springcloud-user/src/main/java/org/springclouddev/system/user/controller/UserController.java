
package org.springclouddev.system.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springclouddev.core.mp.support.Condition;
import org.springclouddev.core.mp.support.Query;
import org.springclouddev.core.secure.SystemUser;
import org.springclouddev.core.secure.utils.SecureUtil;
import org.springclouddev.core.tool.api.R;
import org.springclouddev.core.tool.constant.ToolConstant;
import org.springclouddev.core.tool.utils.Func;
import org.springclouddev.system.user.entity.User;
import org.springclouddev.system.user.service.IUserService;
import org.springclouddev.system.user.vo.UserVO;
import org.springclouddev.system.user.wrapper.UserWrapper;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author zhaobohao
 */
@RestController
@RequestMapping
@AllArgsConstructor
public class UserController {

	private IUserService userService;

	/**
	 *
	 * @return 当前用户的相关信息
	 */
	@ApiOperationSupport(order = 11)
	@ApiOperation(value = "查看当前登录用户详情", notes = "已经登录用户的详细信息")
	@GetMapping("/get-current-user-info")
	public R<String> getCurrentUserInfo()
	{
		SystemUser systemUser= SecureUtil.getUser();
        return R.data("{"+
				"    roles: ['admin'],\n" +
				"    introduction: 'I am a super administrator',\n" +
				"    avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',\n" +
				"    name: 'Super Admin'\n" +
				"  }");
	}


	/**
	 *
	 * @return 当前用户退出
	 */
	@ApiOperationSupport(order = 12)
	@ApiOperation(value = "当前用户退出", notes = "用户相关状态信息清理")
	@GetMapping("/logout")
	public R<String> logout()
	{
		SystemUser systemUser= SecureUtil.getUser();
		return R.data("{data:true"+
				"  }");
	}


	/**
	 * 查询单条
	 */
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "查看详情", notes = "传入id")
	@GetMapping("/detail")
	public R<UserVO> detail(User user) {
		User detail = userService.getOne(Condition.getQueryWrapper(user));
		return R.data(UserWrapper.build().entityVO(detail));
	}
	/**
	 * 查询单条
	 */
	@ApiOperationSupport(order =2)
	@ApiOperation(value = "查看详情", notes = "传入id")
	@GetMapping("/info")
	public R<UserVO> info(SystemUser systemUser) {
		User detail = userService.getById(systemUser.getUserId());
		return R.data(UserWrapper.build().entityVO(detail));
	}

	/**
	 * 用户列表
	 */
	@GetMapping("/list")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "account", value = "账号名", paramType = "query", dataType = "string"),
		@ApiImplicitParam(name = "realName", value = "姓名", paramType = "query", dataType = "string")
	})
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "列表", notes = "传入account和realName")
	public R<IPage<UserVO>> list(@ApiIgnore @RequestParam Map<String, Object> user, Query query, SystemUser systemUser) {
		QueryWrapper<User> queryWrapper = Condition.getQueryWrapper(user, User.class);
		IPage<User> pages = userService.page(Condition.getPage(query), (!systemUser.getTenantId().equals(ToolConstant.ADMIN_TENANT_ID)) ? queryWrapper.lambda().eq(User::getTenantId, systemUser.getTenantId()) : queryWrapper);
		return R.data(UserWrapper.build().pageVO(pages));
	}

	/**
	 * 新增或修改
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增或修改", notes = "传入User")
	public R submit(@Valid @RequestBody User user) {
		return R.status(userService.submit(user));
	}

	/**
	 * 修改
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入User")
	public R update(@Valid @RequestBody User user) {
		return R.status(userService.updateById(user));
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "删除", notes = "传入地基和")
	public R remove(@RequestParam String ids) {
		return R.status(userService.deleteLogic(Func.toLongList(ids)));
	}


	/**
	 * 设置菜单权限
	 *
	 * @param userIds
	 * @param roleIds
	 * @return
	 */
	@PostMapping("/grant")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "权限设置", notes = "传入roleId集合以及menuId集合")
	public R grant(@ApiParam(value = "userId集合", required = true) @RequestParam String userIds,
				   @ApiParam(value = "roleId集合", required = true) @RequestParam String roleIds) {
		boolean temp = userService.grant(userIds, roleIds);
		return R.status(temp);
	}

	@PostMapping("/reset-password")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "初始化密码", notes = "传入userId集合")
	public R resetPassword(@ApiParam(value = "userId集合", required = true) @RequestParam String userIds) {
		boolean temp = userService.resetPassword(userIds);
		return R.status(temp);
	}
	/**
	 * 修改密码
	 *
	 * @param oldPassword
	 * @param newPassword
	 * @param newPassword1
	 * @return
	 */
	@PostMapping("/update-password")
	@ApiOperationSupport(order = 9)
	@ApiOperation(value = "修改密码", notes = "传入密码")
	public R updatePassword(SystemUser systemUser, @ApiParam(value = "旧密码", required = true) @RequestParam String oldPassword,
							@ApiParam(value = "新密码", required = true) @RequestParam String newPassword,
							@ApiParam(value = "新密码", required = true) @RequestParam String newPassword1) {
		boolean temp = userService.updatePassword(systemUser.getUserId(), oldPassword, newPassword, newPassword1);
		return R.status(temp);
	}

	/**
	 * 用户列表
	 *
	 * @param user
	 * @return
	 */
	@GetMapping("/user-list")
	@ApiOperationSupport(order = 10)
	@ApiOperation(value = "用户列表", notes = "传入user")
	public R<List<User>> userList(User user) {
		List<User> list = userService.list(Condition.getQueryWrapper(user));
		return R.data(list);
	}

}
