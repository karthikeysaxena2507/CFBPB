package ConsumerFinancing.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@EnableAspectJAutoProxy
@Component
public class LoggingAspect {

    @Around("execution(* ConsumerFinancing..*(..)))")
    public Object logMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        log.debug("=== Execution time of " + className + "." + methodName + " "
                + ":: " + stopWatch.getTotalTimeMillis() + " ms ===");

        return result;
    }

    @Before("execution(* ConsumerFinancing..*(..)))")
    public void logMethodName(JoinPoint joinPoint) {
        log.debug("=== Starting {} method of {} class ==="
                , joinPoint.getSignature().getName()
                , joinPoint.getSignature().getDeclaringType().getSimpleName());
    }

}