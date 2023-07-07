package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("멤버 서비스 빈 이름 지정")
@Component
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Autowired // ac.getbean(MemberRepository.class) 의 역할과 비슷하다 (getbean보다는 더 많은 역할을 지원한다.)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
