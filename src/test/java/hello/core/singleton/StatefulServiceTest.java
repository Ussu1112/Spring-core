package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
/*
        // ThreadA: A사용자 1000원 주문
        statefulService1.order("userA", 1000);
        // ThreadB: B사용자 2000원 주문 (끼어든 경우)
        statefulService2.order("userB", 2000);

        int price = statefulService1.getPrice();
        // A사용자의 가격을 물었지만 결과는 2000 -> 인스턴스를 공유하고 있기 때문에..
        System.out.println("price = " + price);

        Assertions.assertThat(statefulService2.getPrice()).isEqualTo(2000);
*/

        //------------------------------

        int userAPrice = statefulService1.order("userA", 1000);
        int userBPrice = statefulService2.order("userB", 2000);

        assertThat(userAPrice).isEqualTo(1000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}