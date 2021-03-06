package com.spring.web.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.web.dao.SuperMapper;
import com.spring.web.dao.param.SysUserQueryParam;
import com.spring.web.dao.vo.SysUserQueryVo;
import com.spring.web.dao.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <p>
 * SystemUser Mapper 接口
 * </p>
 *
 * @author zhaobohao
 * @since 2019-08-26
 */
@Repository
public interface SysUserMapper extends SuperMapper<SysUser> {

    /**
     * 根据ID获取查询对象
     * @param id
     * @return
     */
    SysUserQueryVo getSysUserById(Serializable id);

    /**
     * 获取分页对象
     * @param page
     * @param sysUserQueryParam
     * @return
     */
    IPage<SysUserQueryVo> getSysUserPageList(@Param("page") Page page, @Param("param") SysUserQueryParam sysUserQueryParam);

}
