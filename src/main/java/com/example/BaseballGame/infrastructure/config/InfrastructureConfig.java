package com.example.BaseballGame.infrastructure.config;

import com.example.BaseballGame.domain.GameAnswerGenerator;
import com.example.BaseballGame.infrastructure.RandomAnswerGenerator;
import com.example.BaseballGame.domain.GameIdGenerator;
import com.example.BaseballGame.infrastructure.IncrementalGameIdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
DI 컨테이너 코드
객체를 생성하고 관리하면서 의존관계를 연결해 준다.
스프링 빈은 @Bean 이 붙은 메서드의 명을 스프링 빈의 이름으로 사용한다.

@Configuration 을 붙이면 바이트코드를 조작하는 CGLIB 기술을 사용해서 싱글톤을 보장

@Configuration 안에 @Component 가 있다.
따라서 @Configuration 이 붙은 __Config 설정 정보도 자동으로 등록되고 실행됨.
 */
@Configuration
public class InfrastructureConfig {

    @Bean
    public GameAnswerGenerator gameAnswerGenerator(){
        return new RandomAnswerGenerator(1, 9);
    }

    @Bean
    public GameIdGenerator gameIdGenerator(){
        return new IncrementalGameIdGenerator();
    }

}
