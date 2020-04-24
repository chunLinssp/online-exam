package com.jomn.web.core.exception;

import com.jomn.constant.api.Result;
import com.jomn.constant.api.ResultCode;
import com.jomn.constant.api.ResultHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * 全局异常处理器
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     *  验证码输入流异常
     */
    @ExceptionHandler(IOException.class)
    public Result handlerVerificationException(IOException ioException) {
        log.error("验证码照片流出现异常");
        return ResultHandle.BuildFailApiResult(ResultCode.ERROR_PRO_YANZHENGMA);
    }


}
