package coachingmateanalytics.coachingmate.logs;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
@Aspect
public class LogAspectHandler {

    @Autowired(required=false)
    HttpServletRequest request;

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspectHandler.class);

    /***
     * @Description intercept all method in package and subpackage of coachingmateanalytics.coachingmate.controller
     */
    @Pointcut("execution(* coachingmateanalytics.coachingmate.controller..*.*(..))")
    public void controllerPointCut(){}


    /***
     * @Description intercept all method in package and subpackage of coachingmateanalytics.coachingmate.service
     */
    @Pointcut("execution(* coachingmateanalytics.coachingmate.service..*.*(..))")
    public void servicePointCut(){}

    @Before("controllerPointCut()")
    public void dobefore(JoinPoint joinPoint){
        LOGGER.info("===============dobefore============");
        Date begainTime = new Date();
        //debug状态记录
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("Start time: {}  URL: {}",
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(begainTime),
                    request.getRequestURL());
        }

        Signature signature = joinPoint.getSignature();
        String packageName = signature.getDeclaringTypeName();
        String functionName = signature.getName();

        LOGGER.info("The method to be executed is : {}, belongs package : {}",functionName, packageName);
        LOGGER.info("The URL requested by the user is : {}, IP address is : {}", request.getRequestURL(), request.getRemoteAddr());
    }

    @After("controllerPointCut()")
    public void doAfter(JoinPoint joinPoint){
        LOGGER.info("=================doAftere==================");
        Date endTime = new Date();
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("End of the timing: {}  URL: {}",
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(endTime),
                    request.getRequestURL());
        }
        LOGGER.info("The method {} has finished executing", joinPoint.getSignature().getName());

    }

    @AfterReturning(pointcut = "controllerPointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result){
        LOGGER.info("The method {} has finished executing, The return parameter is :{}", joinPoint.getSignature().getName(),result);
    }

    @AfterThrowing(pointcut = "controllerPointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e){
        LOGGER.error("Execute method {} throw an exception {}",joinPoint.getSignature().getName(), e.getMessage());
    }
}
