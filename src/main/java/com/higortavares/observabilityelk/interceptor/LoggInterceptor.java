package com.higortavares.observabilityelk.interceptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

@Aspect
@Configuration
@Slf4j
public class LoggInterceptor {

  @Autowired
  private HttpServletRequest request;

  @Around("@annotation(com.higortavares.observabilityelk.annotations.LoggableHttpRequest)")
  public Object logHttpRequest(ProceedingJoinPoint joinPoint) throws Throwable {
    var proceed = joinPoint.proceed();
    var signature = (MethodSignature) joinPoint.getSignature();
    var timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY - hh:mm:ss.SSS"));
    var method = signature.getMethod().getName();
    var clazz = signature.getMethod().getDeclaringClass().getSimpleName();
    var response = (ResponseEntity) proceed;
    var status = response.getStatusCode().toString();
    var httpMethod = request.getMethod();
    var message = String.format("%s - %s - %s#%s -%s", timestamp, httpMethod, clazz, method, status);

    MDC.put("classe", clazz);
    MDC.put("metodo", method);
    MDC.put("status", status);
    MDC.put("httpMethod", httpMethod);

    log.info(message);
    return proceed;
  }
}
