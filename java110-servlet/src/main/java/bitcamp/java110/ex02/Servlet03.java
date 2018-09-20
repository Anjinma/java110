/* 서블릿 만들기 
 * - javax.servlet.http.HttpServlet 인터페이스 구현
 * 
 */
package bitcamp.java110.ex02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex02/servlet03")
public class Servlet03 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet03.doGet() 호출됨.");
    }


}

// 서블릿 구동 절차
// - 클라이언트가 요청한 URL에 응답할 서블릿을 찾는다.
// - 해당 서블릿의 인스턴스가 이미 생성되었다면, 
//      - service()를 호출한다.
// - 해당 서블릿의 인스턴스가 아직 생성되지 않았다면,
//      - 서블릿 객체 생성 및 생성자 호출
//      - init() 호출
//      - service() 호출
// - 만약 서블릿 컨테이너를 종료하거나 웹 애플리케이션의 실행을 멈춘다면,
//      - 생성된 모든 서블릿들에 대해 destroy() 호출
//      - 생성된 모든 서블릿 객체를 가비지로 만든다.
// 
// 주의!
// - 서블릿 객체는 클래스 당 한 개만 생성된다.
// - 요청할 때마다 생성되는 것이 아니다.
// - 클라이언트마다 객체가 생성되는 것이 아니라 한 객체를 사용하는 것이기 때문에,
//   객체의 인스턴스 변수를 공유하게 된다.
// - 클라이언트 마다 구분해서 값을 저장해야 한다면, 
//   서블릿의 인스턴스 변수를 사용해서는 안된다.
//   왜? 서블릿 객체는 한 개만 생성되고 모든 클라이언트가 공유한다.

































