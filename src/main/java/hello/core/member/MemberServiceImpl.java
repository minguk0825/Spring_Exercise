package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 스프링 빈으로 자동 등록됨
public class MemberServiceImpl extends MemberService {

        private final MemberRepository memberRepository;
        // private final MemberRepository memberRepository = new MemoryMemberRepository();
        // 추상화 에만 의존, 생성자 주입!!

        @Autowired // ac.getBean(MemberRepository.class) 와 같은 효과
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

        // 테스트 용도
        public MemberRepository getMemberRepository() {
            return memberRepository;
        }
}
