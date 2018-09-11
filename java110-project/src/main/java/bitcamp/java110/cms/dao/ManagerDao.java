package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Manager;

//@Component
public interface ManagerDao {

    int insert(Manager manager);
    List<Manager> findAll();
    public Manager findByEmail(String email);
    public int delete(String email);
}
