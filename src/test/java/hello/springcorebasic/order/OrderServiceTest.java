package hello.springcorebasic.order;

import hello.springcorebasic.AppConfig;
import hello.springcorebasic.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void order() {
        //given
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        // when
        Order order = orderService.createOrder(1L, "itemA", 10000);

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
