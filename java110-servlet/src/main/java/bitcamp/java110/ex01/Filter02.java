// 필터 만들기
// - javax.servlet.Filter 인터페이스 구현
//
package bitcamp.java110.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 필터를 만들었으면 어떤 요청에 대해 실행할 것인지 등록해야 한다.
// URL은 반드시 "/"로 시작해야 한다.
//@WebFilter("/ex01/*")
public class Filter02 implements Filter {

    public Filter02() {
        System.out.println("Filter02() 호출됨.");
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter02.init() 호출됨.");
    }
    
    @Override
    public void doFilter(
            ServletRequest request, 
            ServletResponse response, 
            FilterChain chain)
            throws IOException, ServletException {
        
        System.out.println("Filter02.doFilter() --- before");
        chain.doFilter(request, response);
        System.out.println("Filter02.doFilter() -- after");
    }
    
    @Override
    public void destroy() {
        System.out.println("Filter02.destory() 호출됨");
    }

}

























