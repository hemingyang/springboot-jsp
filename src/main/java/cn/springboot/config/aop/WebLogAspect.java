/**
 * 
 */
package cn.springboot.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *  类描述：
 * 
 *  @author:  hemin
 *  @version  $Id: Exp$ 
 *
 *  History:  2019年10月12日 下午1:41:51   hemin   Created.
 *           
 */
@Aspect
@Component
public class WebLogAspect {

	

	 private Logger logger = Logger.getLogger(getClass());

	    ThreadLocal<Long> startTime = new ThreadLocal<>();

	    /**
	     * 方法说明 :切点
	    
	     *
	     * Author：        hemin                
	     * Create Date：   2019年10月12日 下午2:25:17
	     * History:  2019年10月12日 下午2:25:17   hemin   Created.
	     *
	     *
	     */
	    @Pointcut("execution(public * cn.springboot.controller..*.*(..))")
	    public void webLog(){}

	    /**
	     * 方法说明：切面方法
	    
	     *
	     * Author：        hemin                
	     * Create Date：   2019年10月12日 下午2:25:48
	     * History:  2019年10月12日 下午2:25:48   hemin   Created.
	     *
	     * @param joinPoint
	     * @throws Throwable
	     *
	     */
	    @Before("webLog()")
	    public void doBefore(JoinPoint joinPoint) throws Throwable {
	        startTime.set(System.currentTimeMillis());

	        // 省略日志记录内容
	    }

	    @AfterReturning(returning = "ret", pointcut = "webLog()")
	    public void doAfterReturning(Object ret) throws Throwable {
	        // 处理完请求，返回内容
	        logger.info("RESPONSE : " + ret);
	        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
	    }

	    @After("webLog()")
	    public void afterAdvice(){
	        System.out.println("Student profile has been setup."+"初始日志LOGEEER");
	        logger.info("RESPONSE : "+"------------------");
	        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
	     }
	    
	    @AfterThrowing(pointcut = "webLog()", throwing = "ex")
	    public void AfterThrowingAdvice(IllegalArgumentException ex){
	       System.out.println("There has been an exception: " + ex.toString());   
	       logger.info("RESPONSE : " + ex);
	        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
	    }  
	    
	/*
	 * @Pointcut("execution(public * com.wxprogram.service..*.*(..))") public void
	 * serviceLog() {};
	 * 
	 * 
	 * @Before("serviceLog()") public void doserviceBefore(JoinPoint joinPoint)
	 * throws Throwable { startTime.set(System.currentTimeMillis());
	 * 
	 * // 省略日志记录内容 }
	 * 
	 * @AfterReturning(returning = "rets", pointcut = "serviceLog()") public void
	 * doserviceAfterReturning(Object rets) throws Throwable { // 处理完请求，返回内容
	 * logger.info("RESPONSE service: " + rets); logger.info("SPEND TIME service: "
	 * + (System.currentTimeMillis() - startTime.get())); }
	 */

}
