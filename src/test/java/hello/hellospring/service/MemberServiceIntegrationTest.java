// package hello.hellospring.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import hello.hellospring.repository.MemberRepository;

// import org.apache.catalina.startup.ClassLoaderFactory.Repository;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import hello.hellospring.domain.Member;
// import hello.hellospring.repository.MemoryMemberRepository;

// import java.util.Optional;

// // import org.springframework.transaction.annotation.Transactional;

// import static org.assertj.core.api.Assertions.*;
// import static org.junit.jupiter.api.Assertions.assertThrows;


// @SpringBootTest
// // @Transactional 데이터 베아스의 데이터를 롤백해준다.
// class MemberServiceIntegrationTest {

//     @Autowired MemberService memberService;
//     @Autowired MemberRepository memberRepository;

//     @Test
//     void join(){
//         Member member= new Member();
//         member.setName("hello");

//         Long saveId=memberService.join(member);

//         Member findmember= memberService.findOne(saveId).get();
//         assertThat(member.getName()).isEqualTo(findmember.getName());

//     }

//     @Test
//     public void 중복_회원_제외() {
//         Member member1=new Member();
//         member1.setName("spring");

//         Member member2=new Member();
//         member2.setName("spring");

//         memberService.join(member1);
//         assertThrows(IllegalStateException.class, ()-> memberService.join(member2));
//     }

//     @Test
//     void findMembers(){

//     }

//     @Test
//     void findOne(){

//     }
    
// }
