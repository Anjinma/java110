package ex01;

import java.sql.Date;

// 싱글톤 패턴을 적용하기위해서는?
// 일단 생성자 접근을 private으로 막아준다.
// getInstance를 통해 객체를 접근할 수 있도록
// 그리고 static으로 하여 객체 만들때 딱 한번 할수 있도록

public class CarFactory2 {

    public CarFactory2() {}
    
    
    //////////////
    public Car create(String model) {
        Car c = new Car();
        
        switch(model) {
        case "티코":
            c.setModel("Tico");
            c.setCc(890);
            c.setMaker("대우자동차");
            c.setCreatedDate(new Date(System.currentTimeMillis()));
            break;
        case "소나타":
            c.setModel("Sonata");
            c.setCc(1980);
            c.setMaker("현대자동차");
            c.setCreatedDate(new Date(System.currentTimeMillis()));
            break;
        case "그랜져":
            c.setModel("Grandeur");
            c.setCc(1980);
            c.setMaker("현대자동차");
            c.setCreatedDate(new Date(System.currentTimeMillis()));
            break;
        default:
            c.setModel("Avante");
            c.setCc(1500);
            c.setMaker("현대자동차");
            c.setCreatedDate(new Date(System.currentTimeMillis()));
            break;
        }
        return c;
    }
}
