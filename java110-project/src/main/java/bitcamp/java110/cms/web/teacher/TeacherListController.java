package bitcamp.java110.cms.web.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.mvc.RequestMapping;
import bitcamp.java110.cms.service.TeacherService;

@Component
public class TeacherListController{

    @Autowired
    TeacherService teacherService;
    
    @RequestMapping("/teacher/list")
    public String list(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws Exception {
        
        int pageNo=1;
        int pageSize=10;
        
        if(request.getParameter("pageNo")!=null) {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
            if(pageNo<1) {
                pageNo=1;
            }
        }
        
        if(request.getParameter("pageSize")!=null) {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
            if(pageSize < 3 || pageSize>=10) {
                pageSize=3;
            }
        }
        
        List<Teacher> list = teacherService.list(pageNo, pageSize);
        request.setAttribute("list", list);
        return "/teacher/list.jsp";
    }
}