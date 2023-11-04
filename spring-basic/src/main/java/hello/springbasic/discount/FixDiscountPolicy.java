package hello.springbasic.discount;

import hello.springbasic.member.Grade;
import hello.springbasic.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private final int FIX_DISCOUNT_AMOUNT = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return FIX_DISCOUNT_AMOUNT;
        } else {
            return 0;
        }
    }
}
