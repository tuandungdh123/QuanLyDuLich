package com.example.qldl.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
            throws Exception {
        String requestURI = request.getRequestURI();
        if (requestURI.startsWith("/home")) {
            HttpSession httpSession = request.getSession();
            if (httpSession == null || httpSession.getAttribute("role").equals("none")){
                response.sendRedirect("/login");
                return false;
            }
        }
        if (requestURI.startsWith("/admin")) {
            HttpSession httpSession = request.getSession();
            if (httpSession == null || !httpSession.getAttribute("role").equals("Admin")) {
                response.sendRedirect("/errorRole");
                return false;
            }
        }
        return true;
    }
}
