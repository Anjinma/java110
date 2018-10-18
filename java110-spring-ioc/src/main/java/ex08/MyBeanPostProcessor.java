package ex08;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{//객체를 생성한 후 자동으로 실행할 작업들은 먼가 여기서 하면 될껄????!!~!@~!
    /*
     각 객체를 만들고 나서 
     각 객체마다 한번씩 실행 된다.
     객체가 Car Engine 두개라면
     Car
     Engine
     BeanPostProcessor(before,  after)-Car
     BeanPostProcessor(before,  after)-Engine
     
     이런식으로 실행된다.!
    */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization()!!");
        System.out.printf("==>%s\n",bean.toString());
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor.postProcessAfterInitialization()!!");
        System.out.printf("==>%s\n",bean.toString());
        return bean;    
        }
    
    
}
