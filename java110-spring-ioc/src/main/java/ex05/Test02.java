// setter 호출: Set 프로퍼티 값 설정
//
// XML 문법
//      방법1)
//      <property name="프로퍼티명" >
//          <set>...</set>
//      </property>


package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = 
                 new ClassPathXmlApplicationContext("ex05/app-context-2.xml");
        System.out.println("-------------------------------");
        
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 갯수 = %d\n",count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name: names) {
            System.out.printf("=> %s: %s\n",name, iocContainer.getType(name).getName());
        }
        System.out.println("-------------------------------");
        
        
        Car c1 = (Car)iocContainer.getBean("c1");
        System.out.println(c1);
        
        
        /*
         중복되는 것을 넣고 싶다 => 이러면 set 말고 list로 써야함. 타이어 같은거 
         
        */
    }
}
