package com.sandog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sandog on 2019/4/6.
 */
@RestController
public class JinyunController extends BaseController {

    @RequestMapping("/wuzhao")
    public String index(Integer id) {
        System.out.println(getUserName());
        if (id == null) {
            return "巫炤";
        }
        switch (id) {
            case 1 : return "北洛";
            case 2 : return "缙云";
        }
        return "姬轩辕";
    }

}
