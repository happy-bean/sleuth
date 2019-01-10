# sleuth
dubbo日志链路追踪
dubbo springboot

使用：  
1.将源码下载  
2.mvn install 安装到本地  
3.pom 依赖  
```
        <dependency>
            <groupId>org.happy.sleuth</groupId>
            <artifactId>sleuth</artifactId>
            <version>1.0</version>
        </dependency>
 ```
4.springboot项目代码中  

```
@Aspect
@Component
public class DemoAop extends DubboServiceAop {
    @Override
    @Pointcut("execution(* com.xxx..*ProviderImpl.*(..))")
    public void controllerExecute() {
    }
}
```
5.logback.xml  
```
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder charset="UTF-8">
            <pattern>EXCUTE_ID:%X{EXCUTE_ID}</pattern>
        </encoder>
    </appender>
 ```
6.查看日志 
```
 EXCUTE_ID:<8cf3f38f-4fef-4228-9749-e942a8f496d8>2019-01-10 21:48:24.451  INFO 29201 --- [on(4)-127.0.0.1] o.h.sleuth.dubbo.aop.DubboServiceAop : result:null [use:0ms] [EXCUTE_COMPLETE]
```
注：  
8cf3f38f-4fef-4228-9749-e942a8f496d8 为链路唯一标识
