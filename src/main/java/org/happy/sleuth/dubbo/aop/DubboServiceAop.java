package org.happy.sleuth.dubbo.aop;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.happy.sleuth.dubbo.factory.LogParamFactory;
import org.happy.sleuth.dubbo.log.LogParam;
import org.happy.sleuth.dubbo.mdc.DubboMDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @author wgt
 * @date 2019-01-10
 * @description
 **/
public class DubboServiceAop {

    /**
     * 默认使用slf4j
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DubboServiceAop.class);

    /**
     * 定义拦截规则：拦截com.xxx.api.controller包下面的所有类中，有@RequestMapping注解的方法。
     *
     * @param
     */
    @Pointcut("execution(* com.xxx.api.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerExecute() {
    }

    /**
     * 拦截器执行前操作
     *
     * @param point
     * @return
     */
    @Before("controllerExecute()")
    public void excuteBefore(JoinPoint point) {
        long beginTime = System.currentTimeMillis();
        LogParam param = LogParamFactory.buildParam(point);
        DubboMDC.putLogParam(param);
        DubboMDC.put(DubboMDC.EXCUTE_BEGIN_TIME, String.valueOf(beginTime));
        try {
            Object rpcExcuteId = RpcContext.getContext().getAttachments().get(DubboMDC.EXCUTE_ID);
            if (rpcExcuteId != null) {
                String sRpcExcuteId = (String) rpcExcuteId;
                DubboMDC.put(DubboMDC.EXCUTE_ID, sRpcExcuteId);
            }

            String mdcExcuteId = MDC.get(DubboMDC.EXCUTE_ID);
            if (StringUtils.isNotEmpty(mdcExcuteId)) {
                RpcContext.getContext().setAttachment(DubboMDC.EXCUTE_ID, mdcExcuteId);
            }
        } catch (Exception e) {

        }
        LOGGER.info("[EXCUTE_EXCUTE]");
    }

    /**
     * 拦截器执行后操作
     *
     * @param point
     * @return
     */
    @AfterReturning(value = "controllerExecute()", returning = "value")
    public void excuteAfter(JoinPoint point, Object value) {
        String sBeginTime = DubboMDC.get(DubboMDC.EXCUTE_BEGIN_TIME);
        long beginTime = Long.parseLong(sBeginTime);
        long useTime = System.currentTimeMillis() - beginTime;
        LOGGER.info("result:" + JSON.toJSONString(value) + " [use:" + useTime + "ms] " + "[EXCUTE_COMPLETE]");
    }
}
