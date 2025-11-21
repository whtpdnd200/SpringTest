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

        return "/ajax/bookmarkAdd";
    }

    @ResponseBody
    @PostMapping("/add")
    public Map<String, String> addBookMark(
            @RequestParam("title") String title
            , @RequestParam("url") String url) {

        int count = bookMarkService.createBookMark(title, url);
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
        return "/ajax/bookmarkList";
    }
}
