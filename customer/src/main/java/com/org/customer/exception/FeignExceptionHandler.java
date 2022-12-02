package com.org.customer.exception;
import feign.FeignException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestControllerAdvice
public class FeignExceptionHandler {

    @ExceptionHandler(FeignException.NotFound.class)
    public Map<String, Object> handleFeignStatusException(
            FeignException feignException, HttpServletResponse response) throws JSONException {
        response.setStatus(feignException.status());
        return new JSONObject(feignException.contentUTF8()).toMap();
    }
}