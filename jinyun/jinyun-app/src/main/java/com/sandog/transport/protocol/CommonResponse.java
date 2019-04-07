package com.sandog.transport.protocol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by sandog on 2019/4/7.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> extends BaseResponse {

    private T result;

}
