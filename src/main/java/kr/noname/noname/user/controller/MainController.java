package kr.noname.noname.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/style")
    public String index2() {
        return "index_style";
    }
}
