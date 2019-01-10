package org.happy.sleuth.dubbo.factory;

import org.aspectj.lang.JoinPoint;
import org.happy.sleuth.dubbo.log.LogParam;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wgt
 * @date 2019-01-10
 * @description
 **/
public class LogParamFactory {

    public static LogParam buildParam(JoinPoint point) {
        LogParam param = new LogParam();

        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        if (address != null) {
            String localip = address.getHostAddress();
            param.setServiceIp(localip);
        }
        String params = JoinPointFactory.buildParamsString(point);
        param.setParams(params);
        return param;
    }
}
