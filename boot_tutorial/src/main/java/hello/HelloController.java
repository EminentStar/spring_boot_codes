package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 이 클래스는 @RestController로써 flag됨.
 * 이 뜻은 웹 리퀘스트를 처리하기 위한 Spring MVC에 의해 사용될 준비가 되었다는 뜻.
 * */
@RestController
public class HelloController {

    /* @RequsetMapping은 index() 메서드에 "/"를 매핑한다.*/
    @RequestMapping("/")
    public String index(){
	/*
	 * 리퀘스트를 날리면 아래의 text를 출력하는데,
	 * 이것은 @RestController가 @Controller와 @ResponseBody를 combine하기 때문.
	 * Controller와 ResponseBody는 웹 리퀘스트에서 view보다는 단순 데이터를 출력하는 결과를 보여줌
	 * */
        return "Greetings from Spring Boot!";
    }
}

