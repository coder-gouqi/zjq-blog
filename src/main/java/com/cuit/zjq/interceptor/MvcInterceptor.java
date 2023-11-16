package com.cuit.zjq.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MvcInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在拦截点（Controller方法处理之前）执行拦截 若返回的是false则中断执行 反之亦然
        System.out.println("preHandle");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 在处理过程中（Controller方法处理完之后  DispatcherServlet进行视图的渲染之前）执行拦截
        System.out.println("postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在DispatcherServlet进行视图的渲染后 返回前进行拦截
        System.out.println("afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
