package org.happy.sleuth.dubbo.mdc;

import com.alibaba.dubbo.common.utils.StringUtils;
import org.happy.sleuth.dubbo.excute.ExcuteId;
import org.happy.sleuth.dubbo.log.LogParam;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * @author wgt
 * @date 2019-01-10
 * @description
 **/
public class DubboMDC {

    /**
     * 用于整个操作链路标识（uuid作为唯一标识）
     */
    public static final String EXCUTE_ID = "EXCUTE_ID";

    /**
     * 客户端ip
     */
    private static final String IP = "IP";

    /**
     * 用户浏览器 APP 服务器...版本
     */
    private static final String USER_AGENT = "USER_AGENT";

    /**
     * 请求参数
     */
    private static final String PARAMS = "PARAMS";

    /**
     * 请求接口
     */
    private static final String API = "API";

    /**
     * 服务器ip
     */
    private static final String SERVER_IP = "SERVER_IP";

    /**
     * 处理开始时间
     */
    public static final String EXCUTE_BEGIN_TIME = "EXCUTE_BEGIN_TIME";

    public static void putLogParam(LogParam param) {
        MDC.put(IP, param.getRequestIp());
        MDC.put(USER_AGENT, param.getUserAgent());
        MDC.put(PARAMS, param.getParams());
        MDC.put(SERVER_IP, param.getServiceIp());
        MDC.put(API, param.getApi());
        MDC.put(EXCUTE_ID, "<" + ExcuteId.getExcuteId() + ">");
    }

    public static void put(String key, String value) {
        if (StringUtils.isNotEmpty(key) && StringUtils.isNotEmpty(value)) {
            MDC.put(key, value);
        }
    }

    public static String get(String key) {
        if (StringUtils.isNotEmpty(key)) {
            return MDC.get(key);
        }
        return null;
    }
}
