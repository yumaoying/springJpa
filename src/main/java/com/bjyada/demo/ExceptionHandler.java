package com.bjyada.demo;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/10/17.
 */
public class ExceptionHandler  implements HandlerExceptionResolver{
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv=new ModelAndView();
     mv.addObject("errorMsg",e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
