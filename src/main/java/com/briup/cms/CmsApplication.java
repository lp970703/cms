package com.briup.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CmsApplication {
    //swagger2浏览地址是http://localhost:9997/swagger-ui.html
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }

}
