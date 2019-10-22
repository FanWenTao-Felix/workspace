package com.spring.web.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.web.dao.SuperMapper;
import com.spring.web.dao.param.SysLogQueryParam;
import com.spring.web.dao.vo.SysLogQueryVo;
import com.spring.web.dao.entity.SysLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <p>
 * 系统日志 Mapper 接口
 * </p>
 *
 * @author zhaobohao
 * @since 2019-08-04
 */
@Repository
public interface SysLogMapper extends SuperMapper<SysLog> {

    /**
     * 根据ID获取查询对象
     * @param id
     * @return
     */
    SysLogQueryVo getSysLogById(Serializable id);

    /**
     * 获取分页对象
     * @param page
     * @param sysLogQueryParam
     * @return
     */
    IPage<SysLogQueryVo> getSysLogPageList(@Param("page") Page page, @Param("param") SysLogQueryParam sysLogQueryParam);

}
