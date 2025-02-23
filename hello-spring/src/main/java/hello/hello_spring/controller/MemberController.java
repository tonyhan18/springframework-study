package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*
* Spring Container에 Controller 객체를 생성해서 넣어놓는다.
*/
@Controller
public class MemberController {

    /* 컨테이너에 들어가면 이렇게 생성하면 안된다.
    * 각각이 알아서 생성해서 넣어주어야 한다.*/
    //private final MemberService memberService = new MemberService();

    private final MemberService memberService;

    /* 컨테이너에서 MemberService를 가져온다
    * 문제는 MemberService는 순수한 Java Code라서 Service를 변경해주어야 한다
    * Repository도 변경해주어야 한다
    * 이게바로 Spring의 의존성 주입이다*/
    @Autowired
    public MemberController(MemberService memberService)
    {
        this.memberService = memberService;
    }
}
