package com.sandog.jinyun.controller;

import com.sandog.jinyun.service.JinyunService;
import com.sandog.jinyun.transport.protocol.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by sandog on 2019/4/7.
 */
@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private JinyunService jinyunService;

    @RequestMapping("/name_login")
    public CommonResponse<String> NameLogin(String loginName) {
        CommonResponse<String> response = new CommonResponse<>();
        if (StringUtils.isEmpty(loginName)) {
            return response;
        }
        String token = jinyunService.nameLogin(loginName);
        response.setResult(token);
        return response;
    }

}