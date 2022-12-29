package com.jojoIdu.book.springboot.web;

import com.jojoIdu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Json을 반환하는 Controller로 생성
@RestController

public class HelloController {
    //Get의 요청을 받을 수 있는 API로 생성
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    //@Requestparam : 외부에서 API로 넘긴 파라미터를 가져옴
    public HelloResponseDto hellodto(@RequestParam("name") String name
    ,@RequestParam("amount") int amount){

        return new HelloResponseDto(name,amount);

    }
}
