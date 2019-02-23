/*
 * package com.zjzx.filter;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.Filter; import javax.servlet.FilterChain; import
 * javax.servlet.FilterConfig; import javax.servlet.ServletException; import
 * javax.servlet.ServletRequest; import javax.servlet.ServletResponse; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.stereotype.Component;
 * 
 * @Component public class CorsFilter implements Filter {
 * 
 * public void init(FilterConfig filterConfig) throws ServletException { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * public void doFilter(ServletRequest request, ServletResponse response,
 * FilterChain chain) throws IOException, ServletException { // TODO
 * Auto-generated method stub // TODO Auto-generated method stub
 * HttpServletResponse resp =(HttpServletResponse)response;
 * resp.setHeader("Access-Control-Allow-Origin", "*"); chain.doFilter(request,
 * response); }
 * 
 * public void destroy() { // TODO Auto-generated method stub }
 * 
 * 
 * 
 * }
 */