package hello.servlet.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// hello 로 오면 여기가 시작되는 것이다.
@WebServlet(name = "helloServlet", urlPatterns = "/hello") // 1. 서블릿 등록
public class HelloServlet extends HttpServlet { // 2. HttpServlet 상속
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service"); // 3. 서블릿 호출 - 로그가 출력됨
        //soutv - 자동완성
        response.getWriter().write("hello servlet"); // 4. 클라이언트에게 응답

    }
}
