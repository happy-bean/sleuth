package org.happy.sleuth.dubbo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wgt
 * @date 2019-01-10
 * @description
 **/
public class Main {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress ia= InetAddress.getLocalHost();

        String localip=ia.getHostAddress();

        System.out.println(localip);
    }
}
