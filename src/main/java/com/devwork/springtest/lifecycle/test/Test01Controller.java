package com.devwork.springtest.lifecycle.test;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Test01Controller {

    @ResponseBody
    @RequestMapping("/lifecycle/test01/1")
    public String Hello()
    {
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/lifecycle/test01/2")
    public Map<String, Integer> ResponseJson()
    {
        Map<String, Integer> score = new HashMap<>();
        score.put("국어", 80);
        score.put("수학", 90);
        score.put("영어", 85);

        return score;
    }
}
