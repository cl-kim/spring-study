package hello.springbasic.discount;

import hello.springbasic.member.Grade;
import hello.springbasic.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용된다")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 적용되지 않는다")
    void vip_x() {
        //given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}