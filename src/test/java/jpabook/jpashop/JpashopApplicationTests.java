package jpabook.jpashop;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.QMember;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static jpabook.jpashop.domain.QMember.member;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class JpashopApplicationTests {

    @Autowired EntityManager em;
    JPAQueryFactory query;

    @BeforeEach
    public void init() {

        query = new JPAQueryFactory(em);

        Member member1 = new Member();
        member1.setName("karina");
        Member member2 = new Member();
        member2.setName("winter");
        em.persist(member1);
        em.persist(member2);

    }

    @Test
    void contextLoads() {
        List<Member> result = query.selectFrom(member).fetch();
        System.out.println("result =" + result);
        assertThat(result.size()).isEqualTo(2);
    }

}
