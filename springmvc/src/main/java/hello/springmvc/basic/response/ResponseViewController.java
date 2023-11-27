package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV1(Model model) {
        model.addAttribute("data", "hello!");
        return "response/hello";
    }

    /**
     * `@Controller`를 사용하고,
     * HTTP 메세지 바디를 처리하는 파라미터가 없으면
     * 요청 URL을 참고해서 논리 뷰 이름으로 사용한다.
     * 추천하지는 않는 방식이다.
     */
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!");
    }
}
