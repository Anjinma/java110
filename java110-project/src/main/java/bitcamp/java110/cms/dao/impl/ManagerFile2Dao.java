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
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerFile2Dao implements ManagerDao{
    
    static String defaultFilename = "data/manager2.dat";
    String filename;
    private List<Manager> list = new ArrayList<>();
    
    @SuppressWarnings("unchecked")
    public ManagerFile2Dao(String filename) {
        this.filename=filename;
        
        File dataFile = new File(filename);
        try(
                FileInputStream in0=new FileInputStream(dataFile);
                BufferedInputStream in1 = new BufferedInputStream(in0);
                ObjectInputStream in = new ObjectInputStream(in1);
                )
        {
            list = (List<Manager>)in.readObject();//list를 통째로 읽어온다
            /*while (true) {
                try {
                    Manager m = (Manager)in.readObject();//다 읽었냐 안읽었냐를 체크할 때 if( ==null)로 하면 안돼 얘는 예외를 던진다!
                    list.add(m);
                } catch(Exception e) {
//                    e.printStackTrace();
                    break;
                }
            }*/
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ManagerFile2Dao() {
        //코드 중복하지 않기위해 생성자 호출
        this(defaultFilename);//생성자 안에서의 생성자 호출은 항상 첫번째 줄이어야 한다.
    }

    private void save() {
        File dataFile = new File(filename);
        try (
                FileOutputStream out0=new FileOutputStream(dataFile);
                BufferedOutputStream out1 = new BufferedOutputStream(out0);
                ObjectOutputStream out = new ObjectOutputStream(out1);
                ){
            out.writeObject(list);
            /*for (Manager m : list) {
                out.writeObject(m);
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int insert(Manager manager) {
        //필수 입력 항목이 비었을 때,
        if(manager.getName().length() ==0 /*scanner로 받기 때문에 null은 안나옴*/||
                manager.getEmail().length() ==0||
                manager.getPassword().length()==0) {
            //예외처리 문법이 없던 시절에는 리턴값으로 예외 상황을 호출자에게 알렸다.
            return -1;
        }
        for(Manager item : list) {
            if(item.getEmail().equals(manager.getEmail())) {
                // 같은 이메일의 매니저가 있을 경우, 
                // 예외처리 문법이 없던 시절에는 리턴값으로 예외 상황을 호출자에게 알렸다.
                return -2;
            }
        }
        list.add(manager);
        save();
        return 1;
    }

    public List<Manager> findAll() {
        return list;
    }

    public Manager findByEmail(String email) {
        for(Manager item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }

    public int delete(String email) {
        for(Manager item : list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1;
            }
        }
        return 0;
    }
}
