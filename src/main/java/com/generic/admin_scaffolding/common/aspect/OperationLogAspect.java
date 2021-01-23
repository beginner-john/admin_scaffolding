package com.generic.admin_scaffolding.common.aspect;

import com.generic.admin_scaffolding.common.annotation.OperationAspect;
import com.generic.admin_scaffolding.entity.model.OperationRecord;
import com.generic.admin_scaffolding.repository.OperationLogRepository;
import com.generic.admin_scaffolding.utils.DateUtils;
import com.generic.admin_scaffolding.utils.IpAddrUtils;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;


/**
 * @author xiong.bo
 * @version 1.0
 * @date 2021/1/7 14:38
 */

@Aspect
@Component
@Log4j2
public class OperationLogAspect {

    @Autowired
    private OperationLogRepository operationLogRepository;


    @Pointcut("@annotation(com.generic.admin_scaffolding.common.annotation.OperationAspect)")
    public void operationPointCut(){}


    @Around("operationPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //执行方法
        Object result = point.proceed();
        //保存日志
        saveOperationLog(point);
        return result;
    }


    /**
     * 使用了 @Around,是等切面方法执行成功后，才进入下列方法
     */
    private void saveOperationLog(ProceedingJoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        OperationAspect operationLog = signature.getMethod().getAnnotation(OperationAspect.class);

        OperationRecord operation = new OperationRecord();
        // 请求的参数
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            //从获取RequestAttributes中获取HttpServletRequest的信息
            HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

            String ipAddr = IpAddrUtils.getIpAddr(request);
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            operation.setUsername(String.valueOf(principal));
            operation.setAccessPath(operationLog.accessPath());
            operation.setAccessDesc(operationLog.accessDesc());
            operation.setAccessIp(ipAddr);
            operation.setCreateTime(DateUtils.getCurrentTimestamp());

            operationLogRepository.save(operation);

        } catch (Exception e) {
            log.error("操作日志切面异常：" + e);
        }
    }

}
