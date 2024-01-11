package hello.core.member;

public class MemberServiceImpl extends MemberService {

        private final MemberRepository memberRepository;
        // private final MemberRepository memberRepository = new MemoryMemberRepository();
        // 추상화 에만 의존, 생성자 주입!!
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
