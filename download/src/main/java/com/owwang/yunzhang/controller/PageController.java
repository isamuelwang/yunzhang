package com.owwang.yunzhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
        return "t";
    }


}
