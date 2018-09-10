package bitcamp.java110.cms.context;

import java.lang.reflect.Method;
import java.util.HashMap;

import bitcamp.java110.cms.annotation.RequestMapping;

//명령어를 처리할 메서드를 정보를 보관한다.
public class RequestMappingHandlerMapping {

    HashMap<String,RequestMappingHandler>  handlerMap=new HashMap<>();
    
    //객체에 들어있는 @RequestMapping 메서드를 찾아그 정보를 보관한ㄷㅏ.
    public void addMApping(Object instance) {
        Class<?> clazz = instance.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for(Method m:methods) {
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            if(anno==null) {
                continue;
            }
            handlerMap.put(anno.value(), new RequestMappingHandler(instance, m));
        }
    }
    //사용자가 입력한 명령어를 처리할 메서드 정보를 찾아 리턴한다.
    public RequestMappingHandler getMapping(String name) {
        return handlerMap.get(name);
    }
    
    public static class RequestMappingHandler{
        private Object instance;
        private Method method;
        
        public RequestMappingHandler() {}
        
        public RequestMappingHandler(Object instance, Method method) {
            this.instance=instance;
            this.method=method;
        }

        //setter method업고 get메서드만 있는 경우를 Read only 프로ㅌ퍼티라고한다.
        public Object getInstance() {
            return instance;
        }

        public Method getMethod() {
            return method;
        }
        
        
    }
}
