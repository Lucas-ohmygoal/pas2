package com.jfl.pas2.application;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bin Liu
 * @date 2021-07-06-8:27 PM
 */

@ControllerAdvice
public class MyControllerAdvice {
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        ex.printStackTrace();
        Map map = new HashMap();
        map.put("code", 100);
        map.put("message", ex.getMessage());
        return map;
    }

    /**
     * 拦截捕捉自定义异常 BaseException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public Map myErrorHandler(BaseException ex) {
        ex.printStackTrace();
        Map map = new HashMap();
        map.put("Error", ex.getError());
        return map;
    }

}

