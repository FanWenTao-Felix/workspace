package com.spring.demo.service.system.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.demo.entity.SysLog;
import com.spring.demo.mapper.SysLogMapper;
import com.spring.demo.param.SysLogQueryParam;
import com.spring.demo.service.core.impl.BaseServiceImpl;
import com.spring.demo.service.system.SysLogService;
import com.spring.demo.vo.Paging;
import com.spring.demo.vo.SysLogQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author geekidea
 * @since 2019-08-04
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysLogServiceImpl extends BaseServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public SysLogQueryVo getSysLogById(Serializable id) throws Exception{
        return sysLogMapper.getSysLogById(id);
    }

    @Override
    public Paging<SysLogQueryVo> getSysLogPageList(SysLogQueryParam sysLogQueryParam) throws Exception{
        Page page = setPageParam(sysLogQueryParam,OrderItem.desc("create_time"));
        IPage<SysLogQueryVo> iPage = sysLogMapper.getSysLogPageList(page,sysLogQueryParam);
        return new Paging(iPage);
    }

}
