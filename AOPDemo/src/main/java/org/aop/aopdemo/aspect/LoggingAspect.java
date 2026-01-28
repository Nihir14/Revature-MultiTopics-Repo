package org.aop.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Before Advice
    @Before("execution(* org.aop.aopdemo.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before Method: " + joinPoint.getSignature().getName());
    }

    // After Returning Advice
    @AfterReturning(
            pointcut = "execution(* org.aop.aopdemo.service.*.getStatus(..))",
            returning = "result"
    )
    public void logAfterReturning(Object result) {
        System.out.println("Returned Value: " + result);
    }

    // After Throwing Advice
    @AfterThrowing(
            pointcut = "execution(* org.aop.aopdemo.service.*.*(..))",
            throwing = "ex"
    )
    public void logAfterThrowing(Exception ex) {
        System.out.println("Exception Occurred: " + ex.getMessage());
    }

    // Around Advice (FIXED & WORKING)
    @Around("execution(* org.aop.aopdemo.service.PaymentService.makePayment(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("Around Before Method: " + pjp.getSignature().getName());

        Object result = pjp.proceed();   // calls target method

        System.out.println("Around After Method: " + pjp.getSignature().getName());

        return result;
    }
}
