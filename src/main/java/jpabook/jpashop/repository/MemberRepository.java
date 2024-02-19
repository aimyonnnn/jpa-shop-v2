package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

//    @PersistenceContext private EntityManager em;
    private final EntityManager em;
    
    // 회원 저장
    public void save(Member member) {
        em.persist(member);
    }
    
    // 회원 조회 - 단건
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }
    
    // 회원 조회 - 전체
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    // 회원 조회 - 전체 (이름으로 조회)
    public List<Member> findByName(String name) {
        return em.createQuery(
                "select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
