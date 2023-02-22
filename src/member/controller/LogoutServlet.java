package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 현재 세션이 없으면 생성하고, 있으면 해당 세션을 가져옴 (싱글톤처럼)
		HttpSession session = request.getSession();
		if(session!=null) {
			// 2. 세션이 존재하면 invalidate() 메소드로 파괴함
			session.invalidate();
			// 3. 세션 파괴 후 메인페이지로 이동시킴
			response.sendRedirect("/");
		}
	}
}
