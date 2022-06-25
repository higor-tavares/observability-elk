package com.higortavares.observabilityelk.interceptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Configuration
@Slf4j
public class LogInterceptor {

  @Around("@annotation(com.higortavares.observabilityelk.annotations.LoggableHttpRequest)")
  public Object logHttpRequest(ProceedingJoinPoint joinPoint) throws Throwable {

    var signature = (MethodSignature) joinPoint.getSignature();
    var timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY - hh:mm:ss.SSS"));
    var request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
        .getRequest();
    var httpResponse = ((ServletRequestAttributes) RequestContextHolder
        .currentRequestAttributes()).getResponse();
    var method = signature.getMethod().getName();
    var classe = signature.getMethod().getDeclaringClass().getSimpleName();
    var status = HttpStatus.valueOf(httpResponse.getStatus()).toString();
    var httpMethod = request.getMethod();
    var message = String.format("%s - %s - %s#%s -%s", timestamp, httpMethod, classe, method, status);

    MDC.put("classe", classe);
    MDC.put("metodo", method);
    MDC.put("status", status);
    MDC.put("httpMethod", httpMethod);

    log.info(message);
    return joinPoint.proceed();
  }
}
