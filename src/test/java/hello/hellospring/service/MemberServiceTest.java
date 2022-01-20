package hello.hellospring.service;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hello.hellospring.repository.MemoryMemberRepository;

class MemberSeviceTest{

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService =new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join(){
        Member member= new Member();
        member.setName("hello");

        Long saveId=memberService.join(member);

        Member findmember= memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findmember.getName());

    }

    @Test
    public void 중복_회원_제외() {
        Member member1=new Member();
        member1.setName("spring");

        Member member2=new Member();
        member2.setName("spring");

        memberService.join(member1);
        assertThrows(IllegalStateException.class, ()-> memberService.join(member2));
        // try {
        //     memberService.join(member2);
        //     fail("need to raise error");
        // } catch (IllegalStateException e) {
        //     assertThat(e.getMessage()).isEqualTo("member is already exist.");
        // }

    }

    @Test
    void findMembers(){

    }

    @Test
    void findOne(){

    }
}