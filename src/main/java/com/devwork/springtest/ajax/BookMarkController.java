package com.devwork.springtest.ajax;

import com.devwork.springtest.ajax.service.BookMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/bookmark")
@Controller
public class BookMarkController {

    @Autowired
    private BookMarkService bookMarkService;

    @GetMapping("/form")
    public String addForm() {

        return "/ajax/bookmark/bookmarkAdd";
    }

    // 사이트 이름, 주소를 전달 받고, 저장하는 API
    @ResponseBody
    @PostMapping("/add")
    public Map<String, String> addBookMark(
            @RequestParam("title") String title
            , @RequestParam("url") String url
            , @RequestParam("isDuplicateUrl") boolean isDup) {

        int count = bookMarkService.createBookMark(title, url);
        // 성공 : {"result" : "success"}
        // 실패 : {"result" : "fail"}

        if(isDup) {
            return null;
        }

        Map<String, String> bookMarkMap = new HashMap<>();
        if(count == 1) {
            bookMarkMap.put("result", "success");
        } else {
            bookMarkMap.put("result", "fail");
        }

        return bookMarkMap;
    }

    @GetMapping("/info")
    public String info(Model model) {

        model.addAttribute("bookMarkList", bookMarkService.getBookMarkList());
        return "/ajax/bookmark/bookmarkList";
    }

    @ResponseBody
    @GetMapping("/duplicate-url")
    public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {

        Map<String, Boolean> resultMap = new HashMap<>();

        resultMap.put("result", bookMarkService.isDuplicateUrl(url));

        return resultMap;
    }

    @ResponseBody
    @GetMapping("/delete")
    public Map<String, Boolean> deleteBookMarkById(@RequestParam("id") int id) {


        Map<String, Boolean> resultMap = new HashMap<>();
        resultMap.put("result", bookMarkService.deleteBookMarkById(id));

        return resultMap;
    }
}
