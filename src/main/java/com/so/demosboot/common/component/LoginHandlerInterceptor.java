package com.so.demosboot.common.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆检查，
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8");
        Object user = request.getSession().getAttribute("login");
        if(user == null){
            //未登陆，返回登陆页面
            /*request.setAttribute("msg","没有权限请先登陆");
            request.getRequestDispatcher("/login").forward(request,response);*/
            response.getWriter().write("<script>alert('没有权限请先登陆');window.parent.location.href='/login'</script>");
            return false;
        }else{
            //已登陆，放行请求
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }


}
