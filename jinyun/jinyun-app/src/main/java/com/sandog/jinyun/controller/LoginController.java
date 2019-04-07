package com.sandog.jinyun.controller;

import com.sandog.jinyun.transport.protocol.CommonResponse;
import com.sandog.wuzhao.auth.TokenAuth;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sandog on 2019/4/7.
 */
@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

    @RequestMapping("/name_login")
    public CommonResponse<String> NameLogin(String loginName) {
        CommonResponse<String> response = new CommonResponse<>();
        if (StringUtils.isEmpty(loginName)) {
            return response;
        }
        Map<String, Object> map = login(loginName);
        if (map != null) {
            String token = TokenAuth.createJWT(map);
            response.setResult(token);
        }
        return response;
    }

    private Map<String, Object> login(String loginName) {
        Map<String, Object> result = new HashMap<>();
        if ("wuzhao".equals(loginName)) {
            result.put("id", "1");
            result.put("name", "巫炤");
            result.put("kind", "人");
            return result;
        } else if ("beiluo".equals(loginName)) {
            result.put("id", "2");
            result.put("name", "北洛");
            result.put("kind", "妖");
            return result;
        }
        return null;
    }

}
