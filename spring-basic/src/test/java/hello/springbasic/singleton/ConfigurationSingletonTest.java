package hello.springbasic.singleton;

import hello.springbasic.AppConfig;
import hello.springbasic.member.MemberRepository;
import hello.springbasic.member.MemberServiceImpl;
import hello.springbasic.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);

        // 모두 같은 인스턴스가 공유되어 참고되고 있다
        assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());
    }
}
