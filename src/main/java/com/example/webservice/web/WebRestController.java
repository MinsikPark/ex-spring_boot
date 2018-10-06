package com.example.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * @ResponseBody를 모든 메소드에서 적용시켜준다.
 */
public class WebRestController {

    @GetMapping("hello")
    public String hello(){
        return "Hello World";
    }
}
