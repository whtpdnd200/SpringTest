package com.devwork.springtest.database;

import com.devwork.springtest.database.domain.Store;
import com.devwork.springtest.database.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// 스프링 mvc 패턴의 컨트롤러는 순수하게 요청 응답만을 처리함
// 그외의 데이터 가공은 서비스 객체에서 이루어짐
// 기존 mvc2 패턴에서의 컨트롤러가 하던 모든 기능들을
// 유지보수 가독성 측면을 강화 시키기 위해 컨트롤러를
// 컨트롤러(순수한 요청, 응답만을 처리)
// 서비스(레포지토리와 연결 및 추가적인 데이터 가공)
// 으로 쪼개서 개발하는 방식 인거 같음

// 스프링은 pojo 친화적인 프레임 워크다
// 제어의 역전, 의존성 주입이 스프링 어노테이션에 의해 관리 되고 있지만
// 제어와 의존성 주입을 외부(개발자)쪽에서 해준다면 어노테이션이 없이도 동작함
// 어노테이션이 없음 = 순수한 자바 객체
// = pojo 규약을 지킨 자바 코드가 됨
@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;

    // store 테이블의 모든 행을 출력하는 메서드
    @ResponseBody
    @RequestMapping("/db/test01/1")
    public List<Store> getStoreList()
    {
        List<Store> storeList = storeService.getStoreList();
        return storeList;
    }
}
