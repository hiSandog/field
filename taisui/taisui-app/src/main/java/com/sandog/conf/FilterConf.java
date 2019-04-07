package com.sandog.conf;

import com.sandog.filter.LogFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sandog on 2019/4/7.
 */
@Configuration
public class FilterConf {

    @Bean
    public LogFilter getLogFilter() {
        return new LogFilter();
    }

}
