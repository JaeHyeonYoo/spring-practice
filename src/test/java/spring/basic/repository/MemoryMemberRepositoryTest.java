package spring.basic.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spring.basic.member.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    static MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    void clear(){
        memberRepository.clearMember();  //Test 마다 클리어 시키지 않으면 값이 중복 될 수 있다.
    }

    @Test
    void save(){
        Member member = new Member("Mix", 5000); // 임의의 값 지정
        Member saveMember = memberRepository.save(member);// 임의의 값 저장
        Member findMember = memberRepository.findById(saveMember.getId());   // 임의의 값이 제대로 저장되었는지 찾아오기

        assertThat(saveMember).isEqualTo(findMember);
    }
    @Test
    void findAll(){
        Member member1 = new Member("Mix",5000);
        Member member2 = new Member("Max",5500);
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> members = memberRepository.members();

        assertThat(members).contains(member1,member2);
    }


}