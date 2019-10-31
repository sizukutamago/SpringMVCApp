package com.sample.mvc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello/{num}")
    public String index(@PathVariable int num) {
        int total = 0;
        for (int i = 1; i <= num; i++) {
            total += i;
        }
        return "you send :" + num + ".\n" + "total: " + total;
    }
}
