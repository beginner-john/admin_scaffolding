package com.generic.admin_scaffolding.common.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.generic.admin_scaffolding.common.annotation.OperationLog;
import com.generic.admin_scaffolding.entity.model.OperationRecord;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2021/1/7 14:38
 */

@Aspect
@Component
@Log4j2
public class OperationLogAspect {



    @Pointcut("@annotation(com.generic.admin_scaffolding.common.annotation.OperationLog)")
    public void operationPointCut(){}


    @Around("operationPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //执行方法
        Object result = point.proceed();
        //保存日志
        saveOperationLog(point);
        return result;
    }


    private void saveOperationLog(ProceedingJoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        OperationLog operationLog = signature.getMethod().getAnnotation(OperationLog.class);
        // 参数
        Object[] args = joinPoint.getArgs();

        JSONObject errJson = new JSONObject();
        OperationRecord operation = new OperationRecord();
        // 请求的参数
        try {
//            if (log != null && args != null && args.length > 0) {
//                Object params = JSON.parse(JsonAble.toJsonString(args[0]));
//                if (params instanceof JSONObject) {
//                    JSONObject json = (JSONObject) params;
//
//                    operation.setAgentId(json.getString("agentId"));
//                    errJson.put("agentId", json.getString("agentId"));
//                    operation.setUserId(json.getString("userId"));
//                    errJson.put("userId", json.getString("userId"));
//                    operation.setOpera(json.getIntValue("opera"));
//                    errJson.put("opera", json.getString("opera"));
//                    operation.setPoints(json.getLongValue("points"));
//                    errJson.put("points", json.getString("points"));
//                }
//            }
//            operation.setId(RandomUtils.getRandomStrWithTime(16));
//            long time = System.currentTimeMillis();
//            operation.setTime(new Timestamp(time));


        } catch (Exception e) {

            log.info("刷新销售区域缓存结束");
            log.error("保存审核记录出错:userId:" + errJson.getString("userId") + ",agentId:"
                    + errJson.getString("agentId") + ",操作状态:" + errJson.getString("opera")
                    + ",分数为: " + errJson.getString("points")
                    + "errorMessage:" + e.getMessage(), e);
        }

    }

}
