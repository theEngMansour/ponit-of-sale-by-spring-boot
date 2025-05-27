package com.learn.annotation.resolver;

import com.learn.annotation.CurrentUser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class CurrentUserResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        Class<?> paramType = parameter.getParameterType();
        return parameter.hasParameterAnnotation(CurrentUser.class)
                && (paramType.equals(Integer.class) || UserDetails.class.isAssignableFrom(paramType));
    }

    @Override
    public Object resolveArgument(
            @org.springframework.lang.NonNull MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            org.springframework.web.bind.support.WebDataBinderFactory binderFactory
    ) {

        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        if (request != null) {
            Object authAttr = request.getAttribute("auth");
            if (authAttr != null) {
                Class<?> paramType = parameter.getParameterType();
                if (paramType.equals(Integer.class) && authAttr instanceof Integer) {
                    return authAttr;
                }
            }
        }
        return null;
    }
}
