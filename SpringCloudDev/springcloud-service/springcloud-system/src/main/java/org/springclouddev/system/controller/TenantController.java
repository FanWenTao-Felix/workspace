
package org.springclouddev.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springclouddev.core.boot.ctrl.AbstractController;
import org.springclouddev.core.mp.support.Condition;
import org.springclouddev.core.mp.support.Query;
import org.springclouddev.core.secure.SystemUser;
import org.springclouddev.core.tool.api.R;
import org.springclouddev.core.tool.constant.ToolConstant;
import org.springclouddev.core.tool.utils.Func;
import org.springclouddev.system.entity.Tenant;
import org.springclouddev.system.service.ITenantService;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author zhaobohao
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tenant")
@ApiIgnore
@Api(value = "租户管理", tags = "接口")
public class TenantController extends AbstractController {

	private ITenantService tenantService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入tenant")
	public R<Tenant> detail(Tenant tenant) {
		Tenant detail = tenantService.getOne(Condition.getQueryWrapper(tenant));
		return R.data(detail);
	}

	/**
	 * 分页
	 */
	@GetMapping("/list")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "tenantId", value = "参数名称", paramType = "query", dataType = "string"),
		@ApiImplicitParam(name = "tenantName", value = "角色别名", paramType = "query", dataType = "string"),
		@ApiImplicitParam(name = "contactNumber", value = "联系电话", paramType = "query", dataType = "string")
	})
	@ApiOperation(value = "分页", notes = "传入tenant")
	public R<IPage<Tenant>> list(@ApiIgnore @RequestParam Map<String, Object> tenant, Query query, SystemUser systemUser) {
		QueryWrapper<Tenant> queryWrapper = Condition.getQueryWrapper(tenant, Tenant.class);
		IPage<Tenant> pages = tenantService.page(Condition.getPage(query), (!systemUser.getTenantId().equals(ToolConstant.ADMIN_TENANT_ID)) ? queryWrapper.lambda().eq(Tenant::getTenantId, systemUser.getTenantId()) : queryWrapper);
		return R.data(pages);
	}

	/**
	 * 下拉数据源
	 */
	@GetMapping("/select")
	@ApiOperation(value = "下拉数据源", notes = "传入tenant")
	public R<List<Tenant>> select(Tenant tenant, SystemUser systemUser) {
		QueryWrapper<Tenant> queryWrapper = Condition.getQueryWrapper(tenant);
		List<Tenant> list = tenantService.list((!systemUser.getTenantId().equals(ToolConstant.ADMIN_TENANT_ID)) ? queryWrapper.lambda().eq(Tenant::getTenantId, systemUser.getTenantId()) : queryWrapper);
		return R.data(list);
	}

	/**
	 * 自定义分页
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入tenant")
	public R<IPage<Tenant>> page(Tenant tenant, Query query) {
		IPage<Tenant> pages = tenantService.selectTenantPage(Condition.getPage(query), tenant);
		return R.data(pages);
	}

	/**
	 * 新增或修改
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入tenant")
	public R submit(@Valid @RequestBody Tenant tenant) {
		if(tenantService.saveTenant(tenant))
		{
			return R.data(tenant);
		}else {
			return R.data(HttpServletResponse.SC_SERVICE_UNAVAILABLE, tenant, ToolConstant.DEFAULT_FAILURE_MESSAGE);
		}
	}


	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(tenantService.deleteLogic(Func.toLongList(ids)));
	}


}
