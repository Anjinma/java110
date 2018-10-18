package ex07;

import java.beans.PropertyEditorSupport;

public class EnginePropertyEditor extends PropertyEditorSupport{
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] str = text.split(",");
        
        String maker = str[0];
        int valve = Integer.parseInt(str[1]);
        boolean isDiesel = Boolean.parseBoolean(str[2]);
        
        Engine e = new Engine(maker,valve,isDiesel);
        
        
        this.setValue(e);
    }
}
