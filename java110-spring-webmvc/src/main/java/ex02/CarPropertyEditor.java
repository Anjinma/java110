package ex02;

import java.beans.PropertyEditorSupport;


// String ==> ex02.Car 프로퍼티변환기
public class CarPropertyEditor extends PropertyEditorSupport{
    
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {// 문자열 니 맘대로 바꿀수 있어!!!
            String[] values = text.split(",");
            Car car = new Car();
            car.setModel(values[0]);
            car.setMaker(values[1]);
            car.setAuto(Boolean.parseBoolean(values[2]));
            
            this.setValue(car);
            
        } catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }
    
    @Override
    public Object getValue() {

        return super.getValue();
    }
}
