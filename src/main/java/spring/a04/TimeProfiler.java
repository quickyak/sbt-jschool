package spring.a04;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy
public class TimeProfiler {

    private ThreadLocal<Long> timer = ThreadLocal.withInitial(() -> Long.valueOf(0));

    @Before("execution(public double spring.a04.*.*(..)))")
    public void start() {
        System.out.println("set timer");
        this.timer.set(System.nanoTime());
    }

    @After("execution(public double spring.a04.*.*(..)))")
    public void after() {
        System.out.println("Elapsed time: " + (System.nanoTime() - this.timer.get()) + " ns");
    }
}
