package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import org.springframework.stereotype.Component;

@Component // 스프링 빈으로 자동 등록됨
@MainDiscountPolicy // @Qualifier("mainDiscountPolicy")와 같은 역할
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10; // 10% 할인
    @Override
    public int discount(hello.core.member.Member member, int price) {
        if (member.getGrade() == hello.core.member.Grade.VIP){
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
