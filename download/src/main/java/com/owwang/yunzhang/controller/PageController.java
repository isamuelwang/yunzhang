package com.owwang.yunzhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname PageController
 * @Description TODO
 * @Date 2020-02-13
 * @Created by WANG
 */
@Controller
public class PageController {

    @RequestMapping(value={"/index","/"})
    public String index() {
        System.out.println("11111111111");
        return "t";
    }


}
