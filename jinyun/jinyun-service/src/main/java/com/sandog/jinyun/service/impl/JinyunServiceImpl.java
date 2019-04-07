package com.sandog.jinyun.service.impl;

import com.sandog.jinyun.model.GjUser;
import com.sandog.jinyun.service.JinyunService;
import com.sandog.wuzhao.auth.TokenAuth;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sandog on 2019/4/7.
 */
@Service
public class JinyunServiceImpl implements JinyunService {

    @Override
    public String nameLogin(String name) {
        GjUser gjUser = login(name);
        return TokenAuth.createJWT(createMap(gjUser));
    }

    private Map<String, Object> createMap(GjUser gjUser) {
        if (gjUser == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("id", gjUser.getId());
        map.put("name", gjUser.getName());
        map.put("kind", gjUser.getKind());
        return map;
    }

    private GjUser login(String loginName) {
        if ("wuzhao".equals(loginName)) {
            return GjUser.builder()
                    .id(1)
                    .name("巫炤")
                    .kind("人").build();
        } else if ("beiluo".equals(loginName)) {
            return GjUser.builder()
                    .id(2)
                    .name("北洛")
                    .kind("妖").build();
        }
        return null;
    }

}
