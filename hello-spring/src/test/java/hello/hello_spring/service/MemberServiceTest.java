package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.assertj.core.api.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

// static 멤버를 클래스 이름 없이 직접 사용할 수 있음
import static org.assertj.core.api.Assertions.*;

/* Shift + F10 을 해서 이전에 했던 실행을 동일하게 반복할 수 있다 */
class MemberServiceTest {


    /* 테스트 과정 중 중복해서 데이터가 쌓이는 문제를 해결하기 위해
    AfterEach를 발동시키기 위한 Repository 클래스도 가져왔다
    하지만 이렇게하면 다른 테스트와 우연하게 객체가 겹칠 수 있기 때문에
    BeforeEach로 각 클래스에 우리가 객체를 생성해서 삽입해주어야 한다
    */
    //MemberService memberService = new MemberService();
    //MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService;
    MemoryMemberRepository memberRepository;


    @BeforeEach
    public void beforeEach()
    {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach()
    {
        memberRepository.clearStore();
    }



    /* 테스트 코드는 그냥 한글로 작성해주어도 된다.*/
    @Test
    void 회원가입() {
        /* 테스트 코드는 given, when, then으로 나누어서 구현한다*/
        // given = 변수 셋팅
        Member member = new Member();
        member.setName("hello");

        // when = 로직
        Long saveId = memberService.join(member);

        // then = 테스트
        /* ctrl + shift + enter = Code Complete*/
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    /* 테스트는 정상보다 예외를 테스트하는게 더 중요하다
    * 그래서 예외를 테스트 하는 로직을 확인해보자*/
    @Test
    void 중복_회원_예외()
    {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);

        //        memberService.join(member1);
//        try{
//            memberService.join(member2);
//            fail(); // 예외가 발생하지 않으면 테스트를 실패시키기 위한 용도
//        }catch(IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        }

        /* 로직을 실행시 IllegalStateException이 터지는 부분이다. */
        // org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        // org.junit.jupiter.api.Assertions.assertThrows(NullPointerException.class, ()-> memberService.join(member2));

        /* ctrl + alt + v => 곧장 변수로 뽑아낼 수 있다 */
        IllegalStateException e = org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");


        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}