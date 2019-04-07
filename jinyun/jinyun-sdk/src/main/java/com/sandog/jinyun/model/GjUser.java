package com.sandog.jinyun.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Created by sandog on 2019/4/7.
 */
@Data
@Builder
@AllArgsConstructor
public class GjUser {

    private Integer id;
    private String name;
    private String kind;

}
