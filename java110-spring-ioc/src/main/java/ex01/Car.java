package ex01;

import java.sql.Date;

public class Car {
    private int no;
    private String model;
    private String maker;
    private int cc;
    private Date createdDate;
    
    public Car() {
        System.out.println("Car() 기본 생성자 호출도미!");
    }
    
    public Car(String model, int cc) {
        System.out.println("Car(String, int) 기본 생성자 호출도미!");
        this.model = model;
        this.cc = cc;
    }
    
    public Car(int cc, String model) {
        System.out.println("Car(int, String) 기본 생성자 호출도미!");
        this.cc = cc;
        this.model = model;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Car [no=" + no + ", model=" + model + ", maker=" + maker + ", cc=" + cc + ", createdDate=" + createdDate
                + "]";
    }
    
    
    
}
