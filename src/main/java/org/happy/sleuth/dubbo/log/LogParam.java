package org.happy.sleuth.dubbo.log;

/**
 * @author wgt
 * @date 2019-01-10
 * @description
 **/
public class LogParam {

    /**
     * 调用方ip
     */
    private String requestIp;

    /**
     * 被调用方ip
     */
    private String serviceIp;

    /**
     * 调用方信息
     */
    private String userAgent;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 调用接口名称
     */
    private String api;

    public LogParam() {
    }

    public LogParam(String requestIp, String serviceIp, String userAgent, String params, String api) {
        this.requestIp = requestIp;
        this.serviceIp = serviceIp;
        this.userAgent = userAgent;
        this.params = params;
        this.api = api;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getServiceIp() {
        return serviceIp;
    }

    public void setServiceIp(String serviceIp) {
        this.serviceIp = serviceIp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
