package com.spring.demo.config;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.google.common.collect.Maps;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author miemie
 * @since 2018-08-12
 */
@Configuration
@MapperScan("com.spring.demo.mapper" )
public class MybatisPlusConfig {
    /**
     * 性能分析拦截器，不建议生产使用
     * 用来观察 SQL 执行情况及执行时长
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        return new PerformanceInterceptor();
    }
    /**
     * 1.分页插件
     * 2.多租户
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        // 开启 count 的 join 优化,只针对 left join !!!
        return new PaginationInterceptor().setCountSqlParser(new JsqlParserCountOptimize(true));
    }

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    /**
     * 自定义 SqlInjector
     * 里面包含自定义的全局方法
     * 需要在superMapper里声明，才能够使用。
     */
    @Bean
    public MyLogicSqlInjector myLogicSqlInjector() {
        return new MyLogicSqlInjector();
    }


    /**
     * sequence主键，需要配置一个主键生成器
     * 配合实体类注解 KeySequence + TableId type=INPUT
     * @return
     */
    @Bean
    public H2KeyGenerator h2KeyGenerator(){
        return new H2KeyGenerator();
    }

    /**
     *  防止全表更新(删除).可以看BlockAttackSqlParser的源代码。
     * @return
     */
    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor(){
        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();

        //动态替换表名
        DynamicTableNameParser dynamicTableNameParser=new DynamicTableNameParser();
        Map<String, ITableNameHandler> sqlmap=new HashMap<>();
        //具体替换策略在TableNameHandleSample
        sqlmap.put("table_replace",new TableNameHandleSample());
        dynamicTableNameParser.setTableNameHandlerMap(sqlmap);
        List<ISqlParser> sqlParserList = new ArrayList<>();
        //防止整库删除
        sqlParserList.add(new BlockAttackSqlParser());
        //动态表名
        sqlParserList.add(dynamicTableNameParser);

        sqlExplainInterceptor.setSqlParserList(sqlParserList);
        return sqlExplainInterceptor;
    }




}
