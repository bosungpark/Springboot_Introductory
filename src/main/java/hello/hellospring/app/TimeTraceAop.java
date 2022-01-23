package hello.hellospring.app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Around;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start= System.currentTimeMillis();
        System.out.println(joinPoint.toString());
        try{
            Object result= joinPoint.proceed();
            return result; 
        } finally {
            long finish= System.currentTimeMillis();
            long timeMs= finish-start;
            System.out.println(joinPoint.toString() +" "+ timeMs);
        }
    }
}
