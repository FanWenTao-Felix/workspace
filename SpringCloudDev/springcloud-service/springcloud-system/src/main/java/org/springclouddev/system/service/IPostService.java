package org.springclouddev.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springclouddev.core.mp.base.BaseService;
import org.springclouddev.system.entity.Post;
import org.springclouddev.system.vo.PostVO;

import java.util.List;

/**
 * 岗位表 服务类
 *
 * @author zhaobohao
 */
public interface IPostService extends BaseService<Post> {

    /**
     * 自定义分页
     *
     * @param page
     * @param post
     * @return
     */
    IPage<PostVO> selectPostPage(IPage<PostVO> page, PostVO post);

    /**
     * 获取岗位ID
     *
     * @param tenantId
     * @param postNames
     * @return
     */
    String getPostIds(String tenantId, String postNames);

    /**
     * 获取岗位名
     *
     * @param postIds
     * @return
     */
    List<String> getPostNames(String postIds);

}
