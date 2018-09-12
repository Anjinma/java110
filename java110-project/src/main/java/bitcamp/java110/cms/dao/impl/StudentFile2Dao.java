package bitcamp.java110.cms.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentFile2Dao implements StudentDao {

    private List<Student> list = new ArrayList<>();

    public StudentFile2Dao() {
        File dataFile = new File("data/student.dat");
        try (
                FileInputStream in0 = new FileInputStream(dataFile);
                BufferedInputStream in1 = new BufferedInputStream(in0);
                ObjectInputStream in = new ObjectInputStream(in1);
                ){
            //list = (List<Student>)in.readObject();
            while (true) {
                try {
                    Student s = (Student)in.readObject();
                    list.add(s);
                } catch(Exception e) {
                    break; //객체가 없다면~~
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void save() {
        File dataFile = new File("data/student.dat");
        try (
                FileOutputStream out0=new FileOutputStream(dataFile);
                BufferedOutputStream out1 = new BufferedOutputStream(out0);
                ObjectOutputStream out = new ObjectOutputStream(out1);
                ){
            for(Student s : list) {
                out.writeObject(s);
            }//out.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int insert(Student student) {
        for (Student item : list) {
            if (item.getEmail().equals(student.getEmail())) {
                return 0;
            }
        }
        list.add(student);
        save();
        return 1;
    }
    
    public List<Student> findAll() {
        return list;
    }
    
    public Student findByEmail(String email) {
        for (Student item : list) {
            if (item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for (Student item : list) {
            if (item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1;
            }
        }
        
        return 0;
    }
}
