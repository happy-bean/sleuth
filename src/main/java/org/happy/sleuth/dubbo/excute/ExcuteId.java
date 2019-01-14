package org.happy.sleuth.dubbo.excute;

import java.util.UUID;

/**
 * @author wgt
 * @date 2019-01-14
 * @description
 **/
public class ExcuteId {

    public static String getExcuteId() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }
}
