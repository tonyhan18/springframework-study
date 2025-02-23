package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

/* 이렇게 해야지만 스프링 콘텐이너에서 얘를 인식해서 넣어준다*/
@Controller
// CTRL + SHIFT + T 하면 테스트가 자동으로 만들어진다.
public class MemberService {

    /* private final = 외부 클래스 접근 불가 + 한 번 할당된 값 변경 불가 */
    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    /* Constructor 방식으로 하여 외부 Test에서 본인의 객체를 쓸 수 있게 만들기*/
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     * Service 는 비즈니스 로직에 가깝게 네이밍
     * repository(
     * */

    public Long join(Member member)
    {
        // 같은 이름이 있는 중복 회원은 안된다.
        // 내가 만든 기능이 중복으로 동작해서 빼내고 싶을때는 refactor을 사용하면 된다.
        // ctrl + alt +shift + t
        validateDuplicateMember(member); // 중복 회원 검증
        // 요즘에는 null 체크를 이렇게 하면 된다.
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId)
    {
        return memberRepository.findById(memberId);
    }
}
