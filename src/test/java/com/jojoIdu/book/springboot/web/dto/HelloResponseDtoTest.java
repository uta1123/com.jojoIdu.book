package com.jojoIdu.book.springboot.web.dto;

import com.jojoIdu.book.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat; //검증하고 싶은 대상을 메소드 인자로 받습니다.

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){

        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); //isEqualsTo는 assertj의 동등비교 메소드
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}
