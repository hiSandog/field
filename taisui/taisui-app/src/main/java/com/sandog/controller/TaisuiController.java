package com.sandog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sandog on 2019/4/6.
 */
@RestController
public class TaisuiController {

    @RequestMapping("/")
    public String index(){
        return "gateway";
    }

}
