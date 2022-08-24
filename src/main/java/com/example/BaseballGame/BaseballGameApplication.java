package com.example.BaseballGame;

import com.example.BaseballGame.infrastructure.config.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/*
SpringBootApplication 안에 @ComponentScan이 붙어 있다.
SpringBootApplication 을 쓰지 않을 경우 ApplicationContext 직접 만들어 쓰는 법도 있다.

@ComponentScan 은 @Component 가 붙은 모든 클래스를 스프링 빈으로 등록한다.
이때 스프링 빈의 기본 이름은 클래스명을 사용하되 맨 앞글자만 소문자를 사용한다.

스프링 컨테이너는 @Configuration 이 붙은 Config 를 설정(구성) 정보로 사용한다.
@Bean 이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록한다.
이렇게 스프링 컨테이너에 등록된 객체를 스프링 빈이라 한다
 */
@SpringBootApplication
public class BaseballGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseballGameApplication.class, args);
	}
}
