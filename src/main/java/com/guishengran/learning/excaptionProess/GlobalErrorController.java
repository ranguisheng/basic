package com.guishengran.learning.excaptionProess;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalErrorController {
    @RequestMapping("/myerror")
    public String err(){
        return "请求发生异常";
    }
}
