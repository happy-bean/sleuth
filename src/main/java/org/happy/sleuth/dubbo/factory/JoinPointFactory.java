package org.happy.sleuth.dubbo.factory;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author wgt
 * @date 2019-01-10
 * @description
 **/
public class JoinPointFactory {

    public static String buildParamsString(JoinPoint point) {
//        String[] argNames = ((MethodSignature) point.getSignature()).getParameterNames();
//        Object[] argValues = point.getArgs();
        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < argNames.length; i++) {
//            builder.append(argNames[i]);
//            builder.append(":");
//            builder.append(argValues[i]);
//            builder.append(",");
//        }

        return builder.toString();
    }
}
