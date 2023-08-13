package hello.springcorebasic;

import hello.springcorebasic.discount.RateDiscountPolicy;
import hello.springcorebasic.member.MemberService;
import hello.springcorebasic.member.MemberServiceImpl;
import hello.springcorebasic.member.MemoryMemberRepository;
import hello.springcorebasic.order.OrderService;
import hello.springcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public static RateDiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
