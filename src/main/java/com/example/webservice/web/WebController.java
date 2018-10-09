package com.example.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    @GetMapping("/") // RequestMapping의 get method와 동일한 역할
    public String main(){
        /**
         * handlebars-spring-boot-starter 덕분에 path와 확장자는 자동 지정된다.
         *
         */
        return "main";
    }

}
