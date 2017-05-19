package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by junkyu on 2017. 5. 18..
 */
//JpaRepository는 타입 매개변수 두개를 받음.
// 1. 리포지토리가 사용할 도메인 타입
// 2. 클래스의 ID 프로퍼티 타입
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    /*
    * Database에 Book 객체를 영속화할 수 있는 리포지토리를 선언
    * 스프링 JPA를 사용하기에 간단히 스프링 데이터 JPA의 JpaRepository 인터페이스를
    * 상속하여 인터페이스를 만들면 됨
    *
    * ReadingListRepository와 상속받은 18개 메서드를 구현할지 에 대해 걱정 X
    * 스프링 데이터는 리포지토리를 인터페이스로 정의만 해도 잘 작동할 수 있게 함
    * 인터페이스는 런타임(구체적으로는 애플리케이션이 시작할때)에 자동으로 구현됨
    * */
    List<Book> findByReader(String reader); // 독자의 이름으로 독서 목록 검색
}
