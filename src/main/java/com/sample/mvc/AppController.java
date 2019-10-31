package com.sample.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    MyMemoDataRepository repository;

    @RequestMapping("/msg")
    public String message(Model model) {
        model.addAttribute("msg", "this is message controller");
        return "showMessage";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ModelAndView postForm(@RequestParam("title") String title, @RequestParam("content") String content) {
        MyMemoData memo = new MyMemoData(title, content);
        repository.saveAndFlush(memo);
        ModelAndView mv = new ModelAndView("showMessage");
        mv.addObject("msg", "you write " + memo);
        return mv;
    }

    @RequestMapping("/memo")
    public String memo(Model model) {
        List<MyMemoData> list = repository.findAll();
        String result = "<pre>";
        for (MyMemoData memo : list) {
            result += memo.toString() + "\n";
        }

        result += "</pre>";
        model.addAttribute("msg", result);
        return "showMessage";
    }
}
