// package hello.hellospring.repository;

// import hello.hellospring.repository.MemberRepository;
// import hello.hellospring.domain.Member;

// import java.util.*;

// import javax.naming.spi.DirStateFactory.Result;
// import javax.persistence.EntityManager;

// import org.hibernate.internal.EntityManagerMessageLogger;

// public class JpaMemberRepository implements MemberRepository{

//     private final EntityManager em;

//     public JpaMemberRepository(EntityManager em){
//         this.em=em;
//     }

//     @Override
//     Member save(Member member){
//         em.persist(member);
//         return member;
//     }

//     @Override
//     Optional<Member> findById(Long id){
//         Member member= em.find(Member.class, id);
//         return Optional.ofNullable(member);
//     }

//     @Override
//     Optional<Member> findByName(String name){
//         return em.createQuery("select m from Member m where m.name=:name", Member.class)
//             .setParameter('name', name)
//             .getResultList();

//         return result.stream().findAny();
//     }

//     @Override
//     List<Member> findAll(){
//         List<Member> result= em.createQuery("select m from Member m", Member.class)
//             .getResultList();
//         return result;
//     }
// }
