// @RequestMapping 다루기 : URL 다루기 3
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ex02/test11")
public class Test11 {
    
    // 클래스에 URL을 지정했으면, 메서드에도 @RequestMapping을 붙여야한다.
    //

    
    @RequestMapping  // 위에 썻다고 이거 안쓰는거 아니야 임뫄!
    @ResponseBody
    public String m1() {
        return "ex02.Test11.m1()";
    }

    
}