package com.sandog.controller;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sandog on 2019/4/7.
 */
public class BaseController {

    protected String getUserName () {
        RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();
        System.out.println(request.getHeader("token"));
        return request.getHeader("user_name");
    }

}
