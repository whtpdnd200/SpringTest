package com.devwork.springtest.lifecycle.test;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/lifecycle/test01")
public class Test01Controller {

    @ResponseBody
    @RequestMapping("/1")
    public String stringResponse()
    {
        return  "<html>\n" +
                "   <head><title>Test01</title></head>\n" +
                "   <body>\n" +
                "       <h1>테스트 프로젝트 완성</h1>\n" +
                "       <h3>해당 프로젝트를 통해서 문제 풀이를 진행합니다</h3>\n" +
                "   </body>\n" +
                "</html>";
    }

    @ResponseBody
    @RequestMapping("/2")
    public Map<String, Integer> ResponseJson()
    {
        Map<String, Integer> score = new HashMap<>();
        score.put("국어", 80);
        score.put("수학", 90);
        score.put("영어", 85);

        return score;
    }
}
