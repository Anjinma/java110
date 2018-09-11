package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Teacher;

//@Component
public interface TeacherDao {

    //안써줘도 interface안에 메서드는 public abstract
    int insert(Teacher teacher);
    List<Teacher> findAll();
    Teacher findByEmail(String email) ;
    int delete(String email) ;
}
