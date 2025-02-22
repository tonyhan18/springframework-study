package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model)
    {
        model.addAttribute("data","hello!!");
        return "hello";
    }

    // MVC 방식으로 화면을 랜더링해서 전달하는 방식
    // 외부에서 url 파라미터를 전달 및 받음
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value="name") String name, Model model)
    {
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //Http에서 Body 부에 이 데이터를 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam(value="name") String name)
    {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    /* HttpMessageConverter가 객체를 JSON 타입으로 변경한다
    * JsonConverter(MappingJackson2HttpMessageConverter)는 객체를 JSON으로 변환한다
    * 그냥 문자면 SpringConverter(StringHttpMessageConverter)가 동작한다
    * .NET에서는 InputFormatter와 OutputFormatter가 동작한다
    * */
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name)
    {
        Hello hello = new Hello();
        hello.setName(name);

        /* 이렇게하면 View단으로 Model이 JSON으로 넘어간다*/
        return hello;
    }

    static class Hello {
        private String name;

        /* ALT + INS 하면 getter와 setter가 자동으로 만들어짐 */
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
