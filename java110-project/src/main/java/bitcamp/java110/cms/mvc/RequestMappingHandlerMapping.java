package bitcamp.java110.cms.mvc;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.springframework.stereotype.Component;

// 클라이언트의 요청 URL과 그 요청을 처리하는 메서드 정보를 관리한다.
@Component
public class RequestMappingHandlerMapping {
    // Map으로는 파라미터를 두개밖에 못하니까 어쩔수 없이 클래스로 하나를 만들고
    // 그 다음ㅇ에 Map을 사용하면 세개다 사용 할 수 어ㅣㅆ다.
    public static class Handler{
        public Method method;
        public Object instance;
        
        public Handler(Method m, Object o) {
            method=m;
            instance=o;
        }
    }
    
    HashMap<String,Handler> handlerMap = new HashMap<>();
    
    public Handler getHandler(String url) {
        return handlerMap.get(url);
    }
    
    public void addHandler(String url, Method method, Object instance) {
        handlerMap.put(url, new Handler(method,instance));
    }
    
}

// 오늘의 핵심!!!이게 제일 중요해!!!!ㄴㅁㅇㅁㄴㅇㄴㅁㅇㄴㅁ웆석주석주석