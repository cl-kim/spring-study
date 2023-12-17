package hello.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ItemServiceApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	// 글로벌 설정을 통해서 모든 컨트롤러에 다 적용하는 것도 가능하다.
	// 하지만 글로벌 설정을 하게 되면 BeanValidator가 자동 등록되지 않기 때문에 주의하자.
//	@Override
//	public Validator getValidator() {
//		return new ItemValidator();
//	}
}
