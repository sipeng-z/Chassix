package com.application;

import com.exception.AuthorizeException;
import com.exception.AuthorizeForbiddenException;
import com.exception.BusinessException;
import com.exception.NotFoundException;
import com.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice(annotations = {RestController.class, ResponseBody.class})
@Order(1)
public class RestControllerExceptionTranslator {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @ExceptionHandler(ValidationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
    //ResponseResult handleException(ValidationException exception) {
//        return ResponseResult.error(exception.getMessage(), 400);
//    }
//
//    @ExceptionHandler(org.hsweb.ezorm.rdb.exception.ValidationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    ResponseResult handleException(org.hsweb.ezorm.rdb.exception.ValidationException exception) {
//        return ResponseResult.error(JSON.toJSONString(exception.getValidateResult()), 400);
//    }


    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    ResponseResult handleException(BusinessException exception, HttpServletResponse response) {
        response.setStatus(exception.getStatus());
        if (exception.getCause() != null) {
            logger.error("{}:{}", exception.getMessage(), exception.getStatus(), exception.getCause());
        }
        return ResponseResult.error(exception.getMessage(), exception.getStatus());
    }

    @ExceptionHandler(AuthorizeException.class)
    //@ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseResult handleException(AuthorizeException exception) {
        return ResponseResult.error(exception.getMessage(), exception.getStatus());
    }

    @ExceptionHandler(AuthorizeForbiddenException.class)
    // @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    ResponseResult handleException(AuthorizeForbiddenException exception) {
        return ResponseResult.error(exception.getMessage(), exception.getStatus());
    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    ResponseResult handleException(NotFoundException exception) {
        return ResponseResult.error(exception.getMessage(), 404);
    }

    @ExceptionHandler(Throwable.class)
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseResult handleException(Throwable exception) {
        logger.error("未知错误", exception);
        return ResponseResult.error(exception.getMessage(), 500);
    }

}