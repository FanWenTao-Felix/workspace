package org.springbootdev.common.constant;

import org.springbootdev.core.launch.constant.AppConstant;

public interface LauncherConstant {
    /**
     * nacos namespace id
     */
    String NACOS_NAMESPACE = "f447a694-519a-4255-95f9-bcbb5a5d636";
    /**
     * nacos dev 地址
     */
    String NACOS_DEV_ADDR = "127.0.0.1:8848";

    /**
     * nacos prod 地址
     */
    String NACOS_PROD_ADDR = "172.30.0.48:8848";

    /**
     * nacos test 地址
     */
    String NACOS_TEST_ADDR = "172.30.0.48:8848";

    /**
     * sentinel dev 地址
     */
    String SENTINEL_DEV_ADDR = "127.0.0.1:8858";

    /**
     * sentinel prod 地址
     */
    String SENTINEL_PROD_ADDR = "172.30.0.58:8858";

    /**
     * sentinel test 地址
     */
    String SENTINEL_TEST_ADDR = "172.30.0.58:8858";

    /**
     * 动态获取nacos地址
     *
     * @param profile 环境变量
     * @return addr
     */
    static String nacosAddr(String profile) {
        switch (profile) {
            case (AppConstant.PROD_CODE):
                return NACOS_PROD_ADDR;
            case (AppConstant.TEST_CODE):
                return NACOS_TEST_ADDR;
            default:
                return NACOS_DEV_ADDR;
        }
    }

    /**
     * 动态获取sentinel地址
     *
     * @param profile 环境变量
     * @return addr
     */
    static String sentinelAddr(String profile) {
        switch (profile) {
            case (AppConstant.PROD_CODE):
                return SENTINEL_PROD_ADDR;
            case (AppConstant.TEST_CODE):
                return SENTINEL_TEST_ADDR;
            default:
                return SENTINEL_DEV_ADDR;
        }
    }

}
