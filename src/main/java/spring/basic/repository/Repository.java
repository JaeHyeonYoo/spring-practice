package spring.basic.repository;

import spring.basic.member.Member;

import java.util.List;

public interface Repository{

    public Member save(Member member);
    public Member findById(Long id);
    public List<Member> members();
    public void clearMember();
}
