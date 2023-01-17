package spring.basic.repository;

import spring.basic.member.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMemberRepository implements Repository{

    Map<Long,Member> store = new HashMap<>();
    private static Long sequenceId = 0L;

    @Override
    public Member save(Member member) {  //저장을 하기 위해 Member 를 주입해준다.
        member.setId(++sequenceId);      //저장된 값만큼 Id를 더해주기 위해 ++을 사용한다.
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);   //Id 로 값을 찾아와 반환해준다.
    }

    @Override
    public List<Member> members() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void clearMember() {
        store.clear();
    }
}
