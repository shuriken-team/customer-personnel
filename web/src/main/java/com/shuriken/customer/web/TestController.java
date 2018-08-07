package com.shuriken.customer.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wb-wyh270612 on 2018/8/7.
 */
@RestController
public class TestController {
    @RequestMapping("/")
    public String check(){
        return "success";
    }
}
