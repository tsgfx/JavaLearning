package com.ruichao.springbootwebquickstart;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        // 1. 获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式：" + method);

        // 2. 获取请求的URL地址
        String url = request.getRequestURL().toString(); // http://localhost:8080/request
        System.out.println("请求URL：" + url);
        String uri = request.getRequestURI(); // /request
        System.out.println("请求URI：" + uri);

        // 3. 获取请求协议
        String protocol = request.getProtocol();
        System.out.println("请求协议：" + protocol);

        // 4. 获取请求参数 - name
        String name = request.getParameter("name");
        System.out.println("请求参数 - name：" + name);

        // 5. 获取请求头 - Accept
        String accept = request.getHeader("Accept");
        System.out.println("请求头 - Accept：" + accept);

        return "OK";
    }
}
