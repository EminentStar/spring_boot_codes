package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
/*
 * @SPRINGBOOTAPPLICATION은 아래의 모든 것을 추가하는 편의의 애노테이션이다
 *   - @CONFIGURATION: 이 클래스를 APPLICATION CONTEXT를 위한 BEAN DEFINITION의 소스로써 태그한다
 *   - @ENABLEAUTOCONFIGURATION: SPRING BOOT에게 BEANS을 추가하기 시작하라고 말해준다.
 *                                                      CLASSPATH SETTING, 다른 BEANS, 그리고 다양한 property 설정에 기반하여
 *   - @EnableWebMvc: 일반적인 Spring MVC 앱에서는 이걸 추가할 것임. 하지만 boot에선 이게 classpath상에서 이것이 spring-webmvc를 볼때 자동적으로 추가함.
 *                      이것은 애플리케이션을 flag하는데 웹 애플리케이션으로써, 그리고 DispatcherServlet을 셋업하는 것과 같은 key behavior들을 활성화시킨다
 *   - @ComponentScan: 스프링에게 다른 컴포넌트 컨피규레이션 그리고 서비스를 hello package에서 찾으라고 말한다 컨트롤러를 찾으라고 허락하면서.
 * */
@SpringBootApplication
public class Application {
    /*
    * main()은 Spring Boot의 SpringApplication.run()을 애플리케이션을 launch하는데 사용한다.
    * 이 웹 앱은 web.xml같은 게 없다 이 앱은 순수 자바이며 따로 설정을 잡아주는 걸 해야할 필요가 없다
    * */
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }


    /*
    * CommandLineRunner 메서드가 @Bean으로써 mark되고 이는 앱이 시작될때 실행된다.
    * 이것은 모든 beans를 가져오는데, 이 beans는 이 앱에서 생성되었거나, 고맙게도 Spring Boot에서 자동적으로 생성해준 것이다.
    * 이걸 다 차례대로 출력한다.
    * */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            System.out.println("Lets inspect the beans provided by Spring boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for(String beanName : beanNames){
                System.out.println(beanName);
            }
        };
    }

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

