package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
* @SpringBootApplication 애너테이션은 스프링 컴포넌트 검색과 스프링 부트 자동 구성을 활성화한다.
* 이 애너테이션은 사실 유용한 애너테이션 3개를 묶은 것임.
* > 스프링의 @Configuration: 이 애너테이션이 붙은 클래스를 스프링의 자바 기반 구성 클래스로 지정함.
* > 스프링의 @ComponentScan: 컴포넌트 검색 기능을 활성화해서 웹 컨트롤러 클래스나 다른 컴포넌트 클래스들을 자동으로 검색하여 스프링 애플리케이션 컨텍스트에 빈으로 등록시킨다. @Controller 애너테이션이 붙은 컴포넌트를 검색할 수 있음.
* > 스프링 부트의 @EnableAutoConfiguration: 자동 구성을 해주는.. 수많은 구성 코드를 대체할 수 있는 애너테이션
* */
public class ReadingListApplication {
	/*
	* ReadingListApplication 클래스는 스프링 애플리케이션에서 구성과 부트스트래핑 두가지 역할을 담당.
	* ReadingListApplication은 부트스트랩 클래스이기도 한데
	* main() 메서드가 명령줄에서 실행 가능한 JAR 파일로 애플리케이션을 실행할 수 있게 한다.
	* main() 메서드는 ReadingListApplication 클래스 참조와 명령줄 인자를 SpringApplication.run()메서드에 전달하여 애플리케이션을 실행한다.
	*
	* ReadingListApplication.java는 변경할 일이 거의 없다.
	* 스프링 부트 자동 구성이 제공하는 것 이상으로 추가적인 스프링 구성이 필요하다면,
	* 별도의 @Configuration 애너테이션을 포함한 구성 클래스에서 작성하는 것이 가장 좋다.
	* 이 구성 클래스들은 컴포넌트 검색을 자동으로 추가한다.
	* */
	public static void main(String[] args) {
		SpringApplication.run(ReadingListApplication.class, args);
	}
}
