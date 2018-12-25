package com.guishengran.learning.excaptionProess;


import com.guishengran.learning.web.HelloController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionAdvice {
    public static final Logger logger = LoggerFactory.getLogger(ControllerExceptionAdvice.class);

    @ModelAttribute(value = "ctx")
    public String setContextPath(HttpServletRequest request){
        return request.getContextPath();
    }
    @ExceptionHandler
    public String exceptionProcess(Exception e){
        logger.info("请求发生异常:"+e.getMessage());
        e.printStackTrace();
        return "redirect:/myerror";
    }
}
