package com.iSpringboot;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author guoga
 * @version 16:28 2020/6/6
 */
public class TestAdvice implements ResponseBodyAdvice
{



    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass)
    {
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse)
    {
        return null;
    }
}
