// 객체 생성하기 : Spring IoC 컨테이너 사용2

// 팩토리지만 인스턴스 만들어서

package ex01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// bean = object/객체(역할 강조) = instance(값을 강조할 떄는)
//
//     beanContainer (bean의 생성-소멸 관리)
//          +
// Dependency Injection
//
//         ||
//
//    IoC Container

public class Test05 {
    public static void main(String[] args) {
        
        // 객체의 생성,소멸과 의존객체 주입을 관리하는 
        // bean container(=IoC 컨테이너) 생성하기
        ClassPathXmlApplicationContext iocContainer = 
                 new ClassPathXmlApplicationContext("ex01/app-context2.xml");
        
        //IoC 컨테이너에서 객체 꺼내기
        Car obj = (Car)iocContainer.getBean("c1");
        
        System.out.println(obj);
        
        iocContainer.close();
    }
}
