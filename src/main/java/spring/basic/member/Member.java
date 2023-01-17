package spring.basic.member;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Member {

    private Long id;
    private String itemName;
    private int price;

    public Member(String coffeeName, int price) {
        this.itemName = coffeeName;
        this.price = price;
    }
}
