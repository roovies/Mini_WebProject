package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberService memService = new MemberService();
		int result = memService.login(id, pwd);
		if(result>0) {										// 로그인에 성공하면
			HttpSession session = request.getSession();		// 세션을 가져오거나 생성함
			session.setAttribute("id", id);					// 생성된 세션 객체에 id키값에 id값(test면 test)을 매핑하여 저장
			response.sendRedirect("/"); 					// 세션은 모든 페이지에서 참조할 수 있으므로 request객체를 전달하지 않아도
																// 모든 페이지에서 session 객체를 참조할 수 있으므로 response.sendRedirect로 이동시켜도 됨
		}
		else {
			request.setAttribute("title", "로그인 실패");
			request.setAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			request.setAttribute("link", "/member/login");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}
}
