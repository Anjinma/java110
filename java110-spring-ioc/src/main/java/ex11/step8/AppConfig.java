package ex11.step8;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@ComponentScan(basePackages="ex11.step8")   // <context:component-scan base-package="ex11.step8"/>을 자바소스로
@EnableAspectJAutoProxy                     // <aop:aspectj-autoproxy/>
public class AppConfig {
    
}
