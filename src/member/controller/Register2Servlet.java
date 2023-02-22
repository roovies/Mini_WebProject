package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/member/register/step02")
public class Register2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Register2Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/register2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = 	request.getParameter("id");
		String pwd = 	request.getParameter("pwd");
		String name = 	request.getParameter("name");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = 	email1+"@"+email2;
		String phone = 	request.getParameter("phone");
		String addr1 = 	request.getParameter("addr1");
		String addr2 = 	request.getParameter("addr2");
		String addr = "";
		if(addr2.isEmpty()==true) {
			addr = addr1;
		}
		else {
			addr = addr1+"++"+addr2;
		}
		Member member = new Member(id, pwd, name, email, phone, addr);
		MemberService memService = new MemberService();
		HttpSession session = request.getSession();
		String auth = (String)session.getAttribute("auth");
		if(auth==null) {
			request.setAttribute("title", "회원가입 실패");
			request.setAttribute("msg", "이메일 인증을 완료해야 합니다. 다시 시도해주세요.");
			request.setAttribute("link", "/member/register/step02");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
		else {
			int result = memService.register(member);
			if(result>0) {
				request.setAttribute("title", "회원가입");
				request.setAttribute("msg", "회원가입이");
				request.setAttribute("msg2", "로그인 후 댑스 서비스를 마음껏 누리세요.");
				request.setAttribute("link", "/member/login");
				request.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(request, response);
			}
			else {
				request.setAttribute("title", "회원가입 실패");
				request.setAttribute("msg", "입력값이 잘못되었습니다. 다시 시도해주세요.");
				request.setAttribute("link", "/member/register/step01");
				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
			}

		}
	}

}
