package hello.springbasic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(
                type =  FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    // default package :: componentScan을 하는 클래스의 package가 시작 위치가 된다.
}
