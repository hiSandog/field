package com.sandog.jinyun.transport.protocol;

import lombok.Data;

/**
 * Created by sandog on 2019/4/7.
 */
@Data
public class BaseResponse {

    private int code = 0;
    private String errMsg;

}
