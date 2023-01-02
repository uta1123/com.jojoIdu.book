package com.jojoIdu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//메인클래스
//항상 프로젝트 최상단 위치
@SpringBootApplication
@EnableJpaAuditing //JPAAuditing 활성화
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
