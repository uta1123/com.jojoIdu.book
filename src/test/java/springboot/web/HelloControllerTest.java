package springboot.web;

import com.jojoIdu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class) //스프링부트 테스트와 Jnit사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class) //Controller ControllerAdviser 사용가능 but @Service @Component, @Repository 사용 불가
public class HelloControllerTest {

    @Autowired //Spring이 관리하는 빈을 주입 받음
    private MockMvc mvc; //스프링 mvc 테스트의 시작점 이 클래스를 통해 API 테스트 가능


    @Test
    public void  hello가_리턴된다() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello")) //MockMvc 에 내장된 perform 함수로써 HTTP GET 요청을 해줌
                .andExpect(status().isOk()) // 200인지 검증
                .andExpect(content().string(hello)); //Controller 에서 hello를 리턴하기 때문에 이 값이 맞는지 검증

    }

    @Test
    public void  helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;
        mvc.perform(get("/helloDto") //MockMvc 에 내장된 perform 함수로써 HTTP GET 요청을 해줌
                .param("name",name) //String타입만 사용 가능 , API 테스트시 요청 파라미터로 사용됨 이 값으로 날린다고 생각하면됨
                .param("amount",String.valueOf(amount)))
                .andExpect(jsonPath("$.name",is(name))) // JSON 응답값을 필드별로 검증할 수 있는 메서드 (jsonPath)
                .andExpect(jsonPath("$.amount",is(amount)));


    }
}
