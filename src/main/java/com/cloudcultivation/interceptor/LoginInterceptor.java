package com.cloudcultivation.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Jiejie
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // 针对登录和跳转到登录页面的请求进行放行
        String requestUri = request.getRequestURI();
        if (requestUri.contains("/login") || requestUri.contains("/toLogin") ||
                requestUri.contains("/register") || requestUri.contains("/toRegister")) {
            // 直接放行
            return true;
        }

        //其他请求需要做登录权限拦截判断
        HttpSession session = request.getSession();
        Object type = session.getAttribute("type");
        Object user = session.getAttribute("user");
        Object merchant = session.getAttribute("merchant");
        if (user!=null || type!=null || merchant!=null){
            //登录成功，放行
            return true;
        }



        //没有登录，跳转到index.jsp
        request.setAttribute("message","您还没有登录，请先登录！");
        request.getRequestDispatcher("/index.jsp").forward(request,response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
