package com.oriri.advice;

import com.oriri.common.ResponseResult;
import com.oriri.enums.SysCodeEnum;
import com.oriri.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {
    public ExceptionAdvice() {
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseResult<Object> MethodArgumentNotValidException(Exception exception) throws Throwable {
        log.error("入参参数错误",exception);
        String defaultMessage = ((MethodArgumentNotValidException) exception).getBindingResult().getAllErrors().get(0).getDefaultMessage();
        ResponseResult<Object> responseResult = new ResponseResult<Object>(SysCodeEnum.REQUEST_ERROR.getCode(),defaultMessage);
        return responseResult;
    }

    @ExceptionHandler({BusinessException.class})
    public ResponseResult<Object> businessExceptionHandler(BusinessException exception) throws Throwable {
        log.error("业务异常",exception);
        ResponseResult<Object> responseResult = new ResponseResult<Object>(exception);
        return responseResult;
    }

//    @ExceptionHandler({BaseException.class})
//    public ResponseResult<Object> baseExceptionHandler(BaseException exception) throws Throwable {
//        log.error("系统异常",exception);
//        ResponseResult<Object> responseResult = new ResponseResult<Object>(exception);
//        return responseResult;
//    }

    @ExceptionHandler({Exception.class})
    public ResponseResult<Object> exceptionHandler(Exception exception) throws Throwable {
        log.error("未知异常",exception);
        ResponseResult<Object> responseResult = new ResponseResult<Object>(SysCodeEnum.REQUEST_ERROR.getCode(),SysCodeEnum.REQUEST_ERROR.getMessage());
        return responseResult;
    }
}
