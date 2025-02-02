package personal.llmapiclient.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import personal.llmapiclient.util.PerformanceMeasurer;

import static personal.llmapiclient.util.LogConstant.PERFORMANCE_MEASUREMENT;


@Component
@Aspect
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    private static final String SERVICE_LOGGING_EXECUTION_POINTCUT
            = "execution(* com.example.samplespringproject..service.*.*(..))";
    private static final String CLIENT_LOGGING_EXECUTION_POINTCUT
            = "execution(* com.example.samplespringproject..client.*.*(..))";

    private static final String START
            = "Beginning to '{}.{}' task with parameters: {}";
    private static final String END
            = "'{}.{}' task was executed successfully by {}: '{}', ";

    @Around(SERVICE_LOGGING_EXECUTION_POINTCUT)
    public Object serviceLogAroundForStringValue(ProceedingJoinPoint joinPoint) throws Throwable {
        return performLogging(joinPoint);
    }

    @Around(CLIENT_LOGGING_EXECUTION_POINTCUT)
    public Object clientLogAroundForStringValue(ProceedingJoinPoint joinPoint) throws Throwable {
        return performLogging(joinPoint);
    }

    private Object performLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();

        String[] parameterNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        Object[] parameterValues = joinPoint.getArgs();

        StringBuilder params = new StringBuilder();
        for (int i = 0; i < parameterNames.length; i++) {
            if (i > 0) {
                params.append(", ");
            }
            params.append(parameterNames[i]).append(": ").append(parameterValues[i]);
        }

        log.info(START, className, methodName, params.toString());

        long beforeMemory = PerformanceMeasurer.computeUsedMemory(0);
        long startedAt = PerformanceMeasurer.computeElapsedTime(0);

        Object process = joinPoint.proceed();

        long elapsedTime = PerformanceMeasurer.computeElapsedTime(startedAt);
        long memoryUsage = PerformanceMeasurer.computeUsedMemory(beforeMemory);

        log.info(END + PERFORMANCE_MEASUREMENT,
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName(), className, methodName,
                elapsedTime, memoryUsage);

        return process;
    }
}