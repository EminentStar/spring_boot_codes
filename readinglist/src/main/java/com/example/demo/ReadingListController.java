package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * Created by junkyu on 2017. 5. 18..
 */

/*
* 컴포넌트 검색으로 ReadingListController를 발견하여 자동으로
* 스프링 애플리케이션 컨텍스트에 빈으로 등록하려고 클래스에 @Controller 를 붙임
*
* 또 요청을 처리하는 모든 메서드를 기본 URL 경로인 /로 매핑하려고 @RequestMapping 을 붙임
* */
@Controller
@RequestMapping("/")
public class ReadingListController {
    private static final String reader="craig";

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository){
        this.readingListRepository=readingListRepository;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String readersBooks(Model model){
        /*
        * reader의 Book 리스트를 컨트롤러의 생성자로 주입된 리포지토리에서 조회하는 메소드
        *
        * / 로 들어오는 GET 요청을 처리
        * "books" 키로 Book 목록을 모델에 추가하고 모델을 렌더링할 뷰의 논리적 이름으로 "readingList"를 반환함
        *
        * "readingList"를 논리적 뷰 이름으로 반환하므로 이 뷰도 만들어야 한다.
        *   -> src/main/resources/template 에 readingList.html 만들자
        * */
        List<Book> readingList=readingListRepository.findByReader(reader);
        if(readingList != null){
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String addToReadingList(Book book){
        /*
        * 요청 바디에 있는 데이터를 Book 객체에 바인드하여 /로 들어오는 POST 요청을 처리
        *
        * 이 메서드는 Book 객체의 reader 프로퍼티를 독자의 이름으로 설정한 후 리포지토리의 save() 메서드를 이용하여
        * Book 객체를 저장함
        * 마지막으로 / 로 리다이렉트("readirect:/")하도록 지정하면서 반환함(이 리다이렉트 경로로 들어오는 요청은 다른 컨트롤러 메서드가 처리함)
        * */
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/";
    }
}
