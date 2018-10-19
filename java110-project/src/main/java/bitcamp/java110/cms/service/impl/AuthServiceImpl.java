package bitcamp.java110.cms.service.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.service.AuthService;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired SqlSessionFactory sqlSessionFactory; // 이로인해 setter가 필요없어졌다
    
    @Override
    public Member getMember(
            String email, String password, String memberType) {

        try(SqlSession session = sqlSessionFactory.openSession()){

            HashMap<String,Object> params = new HashMap<>();
            params.put("email", email);
            params.put("password", password);

            if (memberType.equals("manager")) {
                ManagerDao managerDao = session.getMapper(ManagerDao.class);
                // 프록시 패턴 적용
                return managerDao.findByEmailPassword(params);

            } else if (memberType.equals("student")) {
                StudentDao studentDao = session.getMapper(StudentDao.class);
                return studentDao.findByEmailPassword(params);

            } else if (memberType.equals("teacher")) {
                TeacherDao teacherDao = session.getMapper(TeacherDao.class);
                return teacherDao.findByEmailPassword(params);

            } else {
                return null;
            }
        }
    }
}










