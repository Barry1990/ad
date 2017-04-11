package com.gxq.exception;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xuenianxiang on 2017/4/11.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    //全局异常处理

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ModelMap defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelMap result = new ModelMap();
        result.put("result", "0");
        result.put("errorMsg", e.getMessage());
        return result;
    }
}
