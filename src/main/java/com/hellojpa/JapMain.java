package com.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JapMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = em.find(Member.class,"150L");
            member.setName("ZZZ");
            
//            Member member1 = new Member(150L,"A");
//            Member member2 = new Member(160L,"B");
//
//            //영속
//            em.persist(member1);
//            em.persist(member2);


            //비영속상태
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            //영속상태
//            em.persist(member);
//
//            Member findMember = em.find(Member.class,101L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember getName= " + findMember.getName());

//            List<Member> result = em.createQuery("select m from Member as m ",Member.class).getResultList();
//
//            for(Member member :result){
//                System.out.println("member.getName() = " + member.getName());
//            }
            tx.commit();
        }catch ( Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
