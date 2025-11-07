package com.devwork.springtest.lifecycle.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test01Controller {

    @ResponseBody
    @RequestMapping("/lifecycle/test01/1")
    public String Hello()
    {
        return "hello";
    }
}
