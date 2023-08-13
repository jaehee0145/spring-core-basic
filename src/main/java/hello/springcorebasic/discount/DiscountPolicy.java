package hello.springcorebasic.discount;

import hello.springcorebasic.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
