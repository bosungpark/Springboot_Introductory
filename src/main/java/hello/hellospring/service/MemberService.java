package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


public class MemberService {
    
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository= memberRepository;
    }

    @Transactional
    public Long join(Member member) {

        long start=System.currentTimeMillis();

        try{
            validateDuplicateMember(member);
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish= System.currentTimeMillis();
            long timeMs= finish-start;
            System.out.println(timeMs+"ms");
        }
    }

    private void validateDuplicateMember(Member member) {

        memberRepository.findByName(member.getName())
        .ifPresent(m->{
            throw new IllegalStateException("member is already exist.");
        });

    }

    public List<Member> findMembers() {
        long start = System.currentTimeMillis();
        try{
            return memberRepository.findAll();
        } finally {
            long finish=System.currentTimeMillis();
            long timeMs=finish-start;
            System.out.println(timeMs+"ms");
        }
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

