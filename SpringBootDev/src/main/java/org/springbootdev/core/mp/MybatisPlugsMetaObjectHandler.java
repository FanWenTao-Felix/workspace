
package org.springbootdev.core.mp;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

/**
 * mybatisplus自定义填充
 *
 * @author zhaobohao
 */
@Slf4j
public class MybatisPlugsMetaObjectHandler implements com.baomidou.mybatisplus.core.handlers.MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {

	}

	@Override
	public void updateFill(MetaObject metaObject) {

	}

}