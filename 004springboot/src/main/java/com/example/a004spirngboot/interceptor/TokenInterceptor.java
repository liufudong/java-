package com.example.a004spirngboot.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Value("${server.servlet.context-path}")
    private String contextPath;
    @Value("${server.port}")
    private String port;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader("Authorization"); // 假设Token通过HTTP头部的Authorization字段传递
        // 这里添加Token验证逻辑
        // 例如，你可以使用JWT库来解析和验证Token
        // 如果Token无效或不存在，则返回false或设置响应状态码
        StringBuffer url = request.getRequestURL(); // 完整的URL，但不包括查询字符串
//        String queryString = request.getQueryString();
        System.out.println("=======token==" + token + "==getRequestURI=" + request.getRequestURI());

        if (token == null || !isValidToken(token)) {
//            response.setContentType("application/json");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.getWriter().write("{\"error\":\"Unauthorized\"}");
            // 用户未登录，重定向到登录页面
            System.out.println("用户未登录，重定向到登录页面" + "http://localhost:" + port + contextPath + "/login");
            //todo todo 先写死
            response.sendRedirect("http://localhost:" + port +contextPath + "/login");
            return false;

        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    // 示例：验证Token是否有效（这里只是示例，具体实现需根据Token生成逻辑）
    private boolean isValidToken(String token) {
        // 这里应该添加实际的Token验证逻辑
        // 例如，解析Token，检查签名等
        return true; // 假设所有Token都有效
    }
}
